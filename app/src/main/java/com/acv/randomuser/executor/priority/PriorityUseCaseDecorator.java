package com.acv.randomuser.executor.priority;

import com.acv.randomuser.executor.UseCaseExecution;

import java.util.concurrent.Callable;

public class PriorityUseCaseDecorator<T> implements Callable<T>, PriorizableUseCase {

    private UseCaseExecution<T> execution;

    public PriorityUseCaseDecorator(UseCaseExecution<T> execution) {
        this.execution = execution;
    }

    @Override
    public T call() throws Exception {
        return (T) execution.getUseCase().call();
    }

    @Override
    public int getPriority() {
        return execution.getPriority();
    }

    @Override
    public String getDescription() {
        return execution.getClass().toString();
    }
}