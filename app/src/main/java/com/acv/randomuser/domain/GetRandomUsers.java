package com.acv.randomuser.domain;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

public class GetRandomUsers {

    private RandomUserRepository repository;

    public GetRandomUsers(RandomUserRepository repository) {
        this.repository = repository;
    }

    public UseCaseResponse<List<RandomUser>> call() {
        return new UseCaseResponse<>(repository.getRandomUsers(10));
    }
}
