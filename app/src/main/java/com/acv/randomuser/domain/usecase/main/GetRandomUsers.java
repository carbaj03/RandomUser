package com.acv.randomuser.domain.usecase.main;


import android.util.Log;

import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.error.LocalGatewayException;
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
            discartedIds.addAll(obtainIdRemovedUser(repository.obtainAllDeleted()));
            return responseSucces(getNotDuplicated(repository.getRandomUsers()));
        } catch (NetworkException e) {
            return responseError(new NetworkUseCaseError());
        } catch (NetworkGatewayException nge) {
            return responseError(new GetRandomUserError());
        } catch (LocalGatewayException e) {
            return responseError(new GetRandomUserError());
        }
    }

    private Set<Id> obtainIdRemovedUser(List<RandomUser> randomUsers) throws LocalGatewayException {
        Set<Id> ids = new HashSet<>(randomUsers.size());
        for (RandomUser randomUser : randomUsers) {
            ids.add(randomUser.getId());
        }
        return ids;
    }

    private List<RandomUser> getNotDuplicated(List<RandomUser> randomUsers) {
        ArrayList<RandomUser> notDuplicateds = new ArrayList<>();
        if (randomUsers != null) {
            for (RandomUser randomUser : randomUsers) {
                if(!discartedIds.contains(randomUser.getId())){
                    discartedIds.add(randomUser.getId());
                    notDuplicateds.add(randomUser);
                }
            }
        }
        return notDuplicateds;
    }

    private UseCaseResponse<List<RandomUser>> responseSucces(final List<RandomUser> randomUsers) {
        return new UseCaseResponse<>(randomUsers);
    }

    private UseCaseResponse<List<RandomUser>> responseError(UseCaseError error) {
        return new UseCaseResponse<>(error);
    }
}
