package com.acv.randomuser.domain;


import com.acv.randomuser.RandomUserRepository;
import com.acv.randomuser.ui.RandomUserModel;

import java.util.List;

public class GetRandomUsers {

    private RandomUserRepository repository;

    public GetRandomUsers(RandomUserRepository repository) {
        this.repository = repository;
    }

    public UseCaseResponse<List<RandomUserModel>> call() {
        return new UseCaseResponse<>(repository.getRandomUsers(10));
    }
}
