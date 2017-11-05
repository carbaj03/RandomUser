package com.acv.randomuser.executor;

public class UnhandledUseCaseException extends RuntimeException {
    public UnhandledUseCaseException(String interactorName, String initiatorException) {
        super(String.format("Your interactor %s does not handle the exception: %s",
                interactorName, initiatorException));
    }
}
