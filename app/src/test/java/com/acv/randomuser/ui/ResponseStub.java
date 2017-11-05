package com.acv.randomuser.ui;

import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.NetworkUseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.domain.usecase.main.GetRandomUserError;

import java.util.List;

public class ResponseStub {

    public static final UseCaseResponse<List<RandomUser>> ERROR_NET_RESPONSE =
            new UseCaseResponse<>(new NetworkUseCaseError());

    public static final UseCaseResponse<List<RandomUser>> ERROR_INTERNAL_RESPONSE =
            new UseCaseResponse<>(new GetRandomUserError());

    public static final UseCaseResponse<List<RandomUser>> ERROR_RESPONSE =
            new UseCaseResponse<>(new GetRandomUserError());


}