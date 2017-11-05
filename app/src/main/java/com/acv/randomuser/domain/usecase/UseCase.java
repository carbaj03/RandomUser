package com.acv.randomuser.domain.usecase;

import java.util.concurrent.Callable;

public interface UseCase<T extends UseCaseResponse> extends Callable<T> {
    @Override
    T call() throws Exception;
}
