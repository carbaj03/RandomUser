package com.acv.randomuser.domain.usecase.main;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.InternalUseCaseError;
import com.acv.randomuser.domain.usecase.UseCase;
import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;

import java.util.Arrays;
import java.util.List;

public class SaveRandomUser implements UseCase<UseCaseResponse<List<RandomUser>>> {
    private RandomUserRepository localGateway;
    private RandomUser randomUser;

    public SaveRandomUser(
            RandomUserRepository localGateway
    ) {
        this.localGateway = localGateway;
    }

    public void setRandomUser(RandomUser randomUser) {
        this.randomUser = randomUser;
    }

    @Override
    public UseCaseResponse<List<RandomUser>> call() {
        try {
            return responseModel(localGateway.persistRandomUserModel(Arrays.asList(randomUser)));
        } catch (LocalGatewayException ex) {
            return responseError(new DeleteRandomUserError());
        } catch (Exception ex) {
            return responseError(new InternalUseCaseError());
        }
    }

    private UseCaseResponse<List<RandomUser>> responseModel(final List<RandomUser> randomUser) {
        return new UseCaseResponse<>(randomUser);
    }

    private UseCaseResponse<List<RandomUser>> responseError(UseCaseError error) {
        return new UseCaseResponse<>(error);
    }


}
