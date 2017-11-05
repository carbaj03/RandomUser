package com.acv.randomuser.data;


import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.Location;
import com.acv.randomuser.domain.model.Login;
import com.acv.randomuser.domain.model.Name;
import com.acv.randomuser.domain.model.Picture;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.LinkedList;
import java.util.List;

public class RandomUserRepository {

    private RandomUserNetwork network;

    public RandomUserRepository(RandomUserNetwork network) {
        this.network = network;
    }

    public List<RandomUser> getRandomUsers(int numberOfRandomUsers) {
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


}
