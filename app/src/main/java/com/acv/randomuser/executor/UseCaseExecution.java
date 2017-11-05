package com.acv.randomuser.executor;

import com.acv.randomuser.domain.usecase.UseCase;
import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.domain.usecase.UseCaseResult;

import java.util.HashMap;
import java.util.Map;

public class UseCaseExecution<T> {
    private UseCaseResult<T> interactorResult;
    private final Map<Class<? extends UseCaseError>, UseCaseResult<? extends UseCaseError>> errors =
            new HashMap<>(0);
    private final UseCase<UseCaseResponse<T>> interactor;
    private int priority;

    private UseCaseExecution(UseCase<UseCaseResponse<T>> interactor) {
        this.interactor = interactor;
    }

    public static <T> UseCaseExecution<T> create(UseCase<UseCaseResponse<T>> interactor) {
        return new UseCaseExecution<T>(interactor);
    }

    public UseCaseExecution<T> success(UseCaseResult<T> interactorResult) {
        this.interactorResult = interactorResult;
        return this;
    }

    public UseCaseExecution<T> error(Class<? extends UseCaseError> errorClass,
                                     UseCaseResult<? extends UseCaseError> interactorError) {
        this.errors.put(errorClass, interactorError);
        return this;
    }

    public UseCaseExecution<T> priority(int priority) {
        this.priority = priority;
        return this;
    }

    public UseCase<UseCaseResponse<T>> getUseCase() {
        return interactor;
    }

    public UseCaseResult<? extends UseCaseError> getUseCaseErrorResult(
            Class<? extends UseCaseError> errorClass) {
        return errors.get(errorClass);
    }

    public UseCaseResult<T> getUseCaseResult() {
        return interactorResult;
    }

    public void execute(UseCaseInvoker interactorInvoker) {
        interactorInvoker.execute(this);
    }

    public int getPriority() {
        return priority;
    }

}
