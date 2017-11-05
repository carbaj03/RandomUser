package com.acv.randomuser.domain.usecase.main;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.NetworkUseCaseError;
import com.acv.randomuser.domain.usecase.UseCase;
import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;

import java.util.List;

public class GetRandomUsers implements UseCase<UseCaseResponse<List<RandomUser>>> {

    private RandomUserRepository repository;

    public GetRandomUsers(RandomUserRepository repository) {
        this.repository = repository;
    }

    public UseCaseResponse<List<RandomUser>> call() {
        try {
            return responseSucces(repository.getRandomUsers(10));
        } catch (Exception e){
            return responseError(new GetRandomUserError());
        }
    }

    private UseCaseResponse<List<RandomUser>> responseSucces(final List<RandomUser> randomUsers) {
        return new UseCaseResponse<>(randomUsers);
    }

    private UseCaseResponse<List<RandomUser>> responseError(UseCaseError error) {
        return new UseCaseResponse<>(error);
    }
}
