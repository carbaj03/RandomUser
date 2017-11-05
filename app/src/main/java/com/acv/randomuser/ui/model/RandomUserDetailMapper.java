package com.acv.randomuser.ui.model;

import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.ArrayList;
import java.util.List;


public class RandomUserDetailMapper implements Mapper<RandomUser, RandomUserDetailModel> {

    public List<RandomUserDetailModel> map(List<RandomUser> randomUsers) {
        List<RandomUserDetailModel> details = new ArrayList<>();
        for (RandomUser randomUser : randomUsers) {
            details.add(map(randomUser));
        }
        return details;
    }

    @Override
    public RandomUserDetailModel map(RandomUser user) {
        if (user == null) {
            return null;
        }
        return new RandomUserDetailModel(
                user.getFullname(),
                user.getEmail(),
                user.getThumbPicture(),
                user.getGender(),
                user.getRegistered(),
                user.getFullLocation()
        );
    }
}
