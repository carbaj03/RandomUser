package com.acv.randomuser;

import com.acv.randomuser.ui.RandomUserModel;

import java.util.LinkedList;
import java.util.List;

public class RandomUserStub {

    public static List<RandomUserModel> getRandomUsers(int numberOfRandomUsers) {
        List<RandomUserModel> randomUserModels = new LinkedList<>();
        for (int i = 0; i < numberOfRandomUsers; i++) {
            String fullname = "RandomUser - " + i;
            String email = "Email - " + i;
            String picture = "https://i.annihil.us/u/prod/marvel/i/mg/c/60/55b6a28ef24fa.jpg";
            String phone = "44444 " + i;
            RandomUserModel randomUserModel =
                    new RandomUserModel(fullname, email, picture, phone);
            randomUserModels.add(randomUserModel);
        }
        return randomUserModels;
    }

}
