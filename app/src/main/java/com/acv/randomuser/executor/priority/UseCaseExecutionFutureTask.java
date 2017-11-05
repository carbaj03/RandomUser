package com.acv.randomuser.executor.priority;

import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.domain.usecase.UseCaseResult;
import com.acv.randomuser.executor.UnhandledUseCaseException;
import com.acv.randomuser.executor.UseCaseExecution;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class UseCaseExecutionFutureTask<T> extends FutureTask<T> implements PriorizableUseCase {
    private final UseCaseExecution<T> interactorExecution;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final String description;

    public UseCaseExecutionFutureTask(
            UseCaseExecution<T> interactorExecution,
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler
    ) {
        super((Callable<T>) interactorExecution.getUseCase());
        this.interactorExecution = interactorExecution;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        this.description = interactorExecution.getUseCase().getClass().toString();
    }

    @Override
    protected void done() {
        super.done();
        try {
            handleResponse((UseCaseResponse<T>) get());
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        Throwable causeException = e.getCause();
        unhandledException(causeException != null ? causeException : e);
    }

    private void handleResponse(UseCaseResponse<T> response) {
        if (response.hasError()) {
            handleError(response.getError());
        } else {
            handleResult(response.getResult());
        }
    }

    private void handleResult(T result) {
        interactorExecution.getUseCaseResult().onResult(result);
    }

    private void handleError(UseCaseError error) {
        UseCaseResult errorResult =
                interactorExecution.getUseCaseErrorResult(error.getClass());
        if (errorResult != null) {
            errorResult.onResult(error);
        } else {
            unhandledException(new RuntimeException("Unhandled handleError action: " + error.getClass().toString()));
        }
    }

    private void unhandledException(Throwable cause) {
        UnhandledUseCaseException e =
                new UnhandledUseCaseException(description, cause.getClass().getName());
        e.initCause(cause);
        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), e);
    }

    public int getPriority() {
        return interactorExecution.getPriority();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
