package com.acv.randomuser.data;


import com.acv.randomuser.data.local.LocalStorage;
import com.acv.randomuser.data.local.mapper.RandomDeleteUserLocalMapper;
import com.acv.randomuser.data.local.mapper.RandomUserLocalMapper;
import com.acv.randomuser.data.local.model.RandomDeleteUserLocalModel;
import com.acv.randomuser.data.local.model.RandomUserLocalModel;
import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

public class RandomUserRepository {

    private final RandomUserNetwork network;
    private final LocalStorage localStorage;
    private final RandomDeleteUserLocalMapper mapperDelete;
    private final RandomUserLocalMapper mapper;

    public RandomUserRepository(
            RandomUserNetwork network,
            LocalStorage localStorage,
            RandomDeleteUserLocalMapper mapperDelete,
            RandomUserLocalMapper mapper
    ) {
        this.network = network;
        this.localStorage = localStorage;
        this.mapperDelete = mapperDelete;
        this.mapper = mapper;
    }

    public List<RandomUser> getRandomUsers() throws NetworkGatewayException, NetworkException {
        return network.obtainAllRandomUsers();
    }

    public List<RandomUser> persistRandomUserModel(List<RandomUser> randomUsers) throws LocalGatewayException {
        localStorage.deleteAll(RandomUserLocalModel.class);
        localStorage.persist(mapper.inverseMap(randomUsers));
        return randomUsers;
    }

    public void persistDeleteRandomUserModel(List<RandomUser> randomUsers) throws LocalGatewayException {
        localStorage.persist(mapperDelete.inverseMap(randomUsers));
    }

    public List<RandomUser> obtainAllDeleted() throws LocalGatewayException {
        return localStorage.findAll(RandomDeleteUserLocalModel.class, mapperDelete);
    }

    public RandomUser obtainBy(Id id) throws LocalGatewayException {
        return localStorage.findById(RandomUserLocalModel.class, id, mapper);
    }


    public List<RandomUser> deleteBy(Id id) throws LocalGatewayException {
        return localStorage.deleteBy(RandomUserLocalModel.class, id, mapper);
    }
}
