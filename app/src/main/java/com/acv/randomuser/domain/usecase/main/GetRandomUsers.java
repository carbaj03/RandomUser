package com.acv.randomuser.domain.usecase.main;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.NetworkUseCaseError;
import com.acv.randomuser.domain.usecase.UseCase;
import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetRandomUsers implements UseCase<UseCaseResponse<List<RandomUser>>> {

    private RandomUserRepository repository;
    private Set<Id> discartedIds = new HashSet<>();

    public GetRandomUsers(RandomUserRepository repository) {
        this.repository = repository;
    }

    public UseCaseResponse<List<RandomUser>> call() {
        try {
            return responseSucces(getNotDuplicated(repository.getRandomUsers()));
        } catch (NetworkException e) {
            return responseError(new NetworkUseCaseError());
        } catch (NetworkGatewayException nge) {
            return responseError(new GetRandomUserError());
        }
    }

    private List<RandomUser> getNotDuplicated(List<RandomUser> randomUsers) {
        ArrayList<RandomUser> valids = new ArrayList<>();
        if (randomUsers != null) {
            for (RandomUser randomUser : randomUsers) {
                if(!discartedIds.contains(randomUser.getId())){
                    discartedIds.add(randomUser.getId());
                    valids.add(randomUser);
                }
            }
        }
        return valids;
    }

    private UseCaseResponse<List<RandomUser>> responseSucces(final List<RandomUser> randomUsers) {
        return new UseCaseResponse<>(randomUsers);
    }

    private UseCaseResponse<List<RandomUser>> responseError(UseCaseError error) {
        return new UseCaseResponse<>(error);
    }
}
