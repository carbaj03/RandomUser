package com.acv.randomuser.data.local.mapper;

import com.acv.randomuser.data.local.model.IdLocalModel;
import com.acv.randomuser.data.local.model.LocationLocalModel;
import com.acv.randomuser.data.local.model.LoginLocalModel;
import com.acv.randomuser.data.local.model.NameLocalModel;
import com.acv.randomuser.data.local.model.PictureLocalModel;
import com.acv.randomuser.data.local.model.RandomUserLocalModel;
import com.acv.randomuser.domain.mapper.TwoWaysMapper;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.Location;
import com.acv.randomuser.domain.model.Login;
import com.acv.randomuser.domain.model.Name;
import com.acv.randomuser.domain.model.Picture;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RandomUserLocalMapper implements TwoWaysMapper<RandomUserLocalModel, RandomUser> {
    private final TwoWaysMapper<NameLocalModel, Name> nameMapper;
    private final TwoWaysMapper<LocationLocalModel, Location> locationMapper;
    private final TwoWaysMapper<PictureLocalModel, Picture> pictureMapper;
    private final TwoWaysMapper<LoginLocalModel, Login> loginMapper;
    private final TwoWaysMapper<IdLocalModel, Id> idMapper;

    @Inject
    public RandomUserLocalMapper(
            TwoWaysMapper<NameLocalModel, Name> nameMapper,
            TwoWaysMapper<LocationLocalModel, Location> locationMapper,
            TwoWaysMapper<PictureLocalModel, Picture> pictureMapper,
            TwoWaysMapper<LoginLocalModel, Login> loginMapper,
            TwoWaysMapper<IdLocalModel, Id> idMapper
    ) {
        this.nameMapper = nameMapper;
        this.locationMapper = locationMapper;
        this.pictureMapper = pictureMapper;
        this.loginMapper = loginMapper;
        this.idMapper = idMapper;
    }


    public List<RandomUserLocalModel> inverseMap(List<RandomUser> randomUsers) {
        List<RandomUserLocalModel> userLocalModels = new ArrayList<>();
        for (RandomUser randomUser : randomUsers) {
            userLocalModels.add(inverseMap(randomUser));
        }
        return userLocalModels;
    }


    @Override
    public RandomUserLocalModel inverseMap(RandomUser user) {
        if (user == null) {
            return null;
        }
        RandomUserLocalModel randomUser = new RandomUserLocalModel(
                user.getGender(),
                nameMapper.inverseMap(user.getName()),
                locationMapper.inverseMap(user.getLocation()),
                user.getEmail(),
                loginMapper.inverseMap(user.getLogin()),
                user.getDob(),
                user.getRegistered(),
                user.getPhone(),
                user.getCell(),
                idMapper.inverseMap(user.getId()),
                pictureMapper.inverseMap(user.getPicture()),
                user.getNat()
        );

        return randomUser;
    }

    @Override
    public RandomUser map(RandomUserLocalModel user) {
        if (user == null) {
            return null;
        }
        RandomUser randomUser = new RandomUser(
                user.getGender(),
                nameMapper.map(user.getName()),
                locationMapper.map(user.getLocation()),
                user.getEmail(),
                loginMapper.map(user.getLogin()),
                user.getDob(),
                user.getRegistered(),
                user.getPhone(),
                user.getCell(),
                idMapper.map(user.getId()),
                pictureMapper.map(user.getPicture()),
                user.getNat()
        );

        return randomUser;

    }
}