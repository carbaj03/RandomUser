package com.acv.randomuser.ui;

import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.executor.UseCaseExecution;
import com.acv.randomuser.executor.UseCaseInvoker;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class TestUseCaseInvoker {

    private TestUseCaseInvoker() {
    }

    public static UseCaseInvoker create() {
        UseCaseInvoker useCaseInvoker = mock(UseCaseInvoker.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                UseCaseExecution execution = (UseCaseExecution) invocation.getArguments()[0];
                UseCaseResponse response = execution.getUseCase().call();
                UseCaseError error = response.getError();
                if (response.hasError() && execution.getUseCaseErrorResult(error.getClass()) != null) {
                    execution.getUseCaseErrorResult(error.getClass()).onResult(error);
                } else if (execution.getUseCaseResult() != null) {
                    execution.getUseCaseResult().onResult(response.getResult());
                }
                return null;
            }
        }).when(useCaseInvoker).execute(anyUseCaseExecution());
        return useCaseInvoker;
    }

    private static UseCaseExecution<?> anyUseCaseExecution() {
        return any();
    }
}
