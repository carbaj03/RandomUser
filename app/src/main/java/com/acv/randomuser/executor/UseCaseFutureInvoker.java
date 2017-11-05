package com.acv.randomuser.executor;

import com.acv.randomuser.executor.priority.PriorityUseCaseDecorator;
import com.acv.randomuser.executor.priority.UseCaseExecutionFutureTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UseCaseFutureInvoker implements UseCaseInvoker {

    private ExecutorService executor;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public UseCaseFutureInvoker(
            ExecutorService executor,
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler
    ) {
        this.executor = executor;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override
    public <T> Future<T> execute(UseCaseExecution<T> execution) {
        if (execution.getUseCaseResult() != null) {
            return (Future<T>) executor.submit(
                    new UseCaseExecutionFutureTask<>(execution, uncaughtExceptionHandler));
        } else {
            return executor.submit(new PriorityUseCaseDecorator<>(execution));
        }
    }
}