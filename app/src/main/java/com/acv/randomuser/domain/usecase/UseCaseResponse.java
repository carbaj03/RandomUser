package com.acv.randomuser.domain.usecase;

public class UseCaseResponse<T> {

    private UseCaseError error;
    private T result;

    public UseCaseResponse() {
    }

    public UseCaseResponse(UseCaseError error) {
        this.error = error;
    }

    public UseCaseResponse(T result) {
        this.result = result;
    }

    public UseCaseError getError() {
        return error;
    }

    public T getResult() {
        return result;
    }

    public boolean hasError() {
        return error != null;
    }
}
