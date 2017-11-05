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

public class DeleteRandomUser implements UseCase<UseCaseResponse<Boolean>> {
    private final RandomUserRepository repository;
    private RandomUser randomUser;

    public DeleteRandomUser(RandomUserRepository repository) {
        this.repository = repository;
    }

    public void setRandomUser(RandomUser randomUser) {
        this.randomUser = randomUser;
    }

    @Override
    public UseCaseResponse<Boolean> call() {
        try {
            return delete(Arrays.asList(randomUser));
        } catch (LocalGatewayException ex) {
            return responseError(new DeleteRandomUserError());
        } catch (Exception ex) {
            return responseError(new InternalUseCaseError());
        }
    }

    private UseCaseResponse<Boolean> delete(List<RandomUser> randomUsers) throws LocalGatewayException {
        repository.persistDeleteRandomUserModel(randomUsers);
        return responseModel(true);
    }

    private UseCaseResponse<Boolean> responseModel(final Boolean randomUser) {
        return new UseCaseResponse<>(randomUser);
    }

    private UseCaseResponse<Boolean> responseError(UseCaseError error) {
        return new UseCaseResponse<>(error);
    }
}
