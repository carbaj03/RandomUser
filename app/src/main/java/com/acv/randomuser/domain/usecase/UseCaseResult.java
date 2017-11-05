package com.acv.randomuser.domain.usecase;

public interface UseCaseResult<T> {
    void onResult(T result);
}
