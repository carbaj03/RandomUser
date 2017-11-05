package com.acv.randomuser.ui.model;

import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.ui.model.RandomUserModel;

import java.util.ArrayList;
import java.util.List;


public class RandomUserMapper {

    public List<RandomUserModel> map(List<RandomUser> randomUsers) {
        List<RandomUserModel> modelViews = new ArrayList<>();
        for (RandomUser randomUser : randomUsers) {
            modelViews.add(map(randomUser));
        }
        return modelViews;
    }


    public RandomUserModel map(RandomUser user) {
        if (user == null) {
            return null;
        }
        return new RandomUserModel(
                user.getFullname(),
                user.getEmail(),
                user.getThumbPicture(),
                user.getPhone()
        );
    }
}
