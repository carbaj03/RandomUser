package com.acv.randomuser.data;


import com.acv.randomuser.data.local.LocalStorage;
import com.acv.randomuser.data.local.mapper.RandomDeleteUserLocalMapper;
import com.acv.randomuser.data.local.model.RandomDeleteUserLocalModel;
import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

public class RandomUserRepository {

    private final RandomUserNetwork network;
    private final LocalStorage localStorage;
    private final RandomDeleteUserLocalMapper mapperDelete;

    public RandomUserRepository(RandomUserNetwork network, LocalStorage localStorage, RandomDeleteUserLocalMapper mapperDelete) {
        this.network = network;
        this.localStorage = localStorage;
        this.mapperDelete = mapperDelete;
    }

    public List<RandomUser> getRandomUsers() throws NetworkGatewayException, NetworkException {
        return network.obtainAllRandomUsers();
//        List<RandomUser> randomUsers = new LinkedList<>();
//        for (int i = 0; i < numberOfRandomUsers; i++) {
//            randomUsers.add(new RandomUser(
//                    "M",
//                    new Name("title", "Juan", "Perez"),
//                    new Location("mystreet", "mycity", "mystate", "0"),
//                    "myemail",
//                    new Login("myusername", "mypassword", "mysalt", "mymd5", "mysha1", "my256"),
//                    "myDob",
//                    "myRegistered",
//                    "myphone",
//                    "mycell",
//                    new Id("myname", "myvalue"),
//                    new Picture("large", "mymedium", "https://randomuser.me/api/portraits/men/83.jpg"),
//                    "myNat"));
//        }
//        return randomUsers;
    }

    public void persistDeleteRandomUserModel(List<RandomUser> randomUsers) throws LocalGatewayException {
        localStorage.persist(mapperDelete.inverseMap(randomUsers));
    }

    public List<RandomUser> obtainAllDeleted() throws LocalGatewayException {
        return localStorage.findAll(RandomDeleteUserLocalModel.class, mapperDelete);
    }
}
