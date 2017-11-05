package com.acv.randomuser.executor.priority;

public interface PriorizableUseCase {
    int getPriority();

    String getDescription();
}
