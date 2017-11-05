package com.acv.randomuser.data.network.mapper;

import com.acv.randomuser.data.network.RandomUserResult;
import com.acv.randomuser.data.network.model.IdDataModel;
import com.acv.randomuser.data.network.model.LocationDataModel;
import com.acv.randomuser.data.network.model.LoginDataModel;
import com.acv.randomuser.data.network.model.NameDataModel;
import com.acv.randomuser.data.network.model.PictureDataModel;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.Location;
import com.acv.randomuser.domain.model.Login;
import com.acv.randomuser.domain.model.Name;
import com.acv.randomuser.domain.model.Picture;
import com.acv.randomuser.domain.model.RandomUser;


public class UserMapper implements Mapper<RandomUserResult, RandomUser> {
    private final Mapper<NameDataModel, Name> nameMapper;
    private final Mapper<LocationDataModel, Location> locationMapper;
    private final Mapper<PictureDataModel, Picture> pictureMapper;
    private final Mapper<LoginDataModel, Login> loginMapper;
    private final Mapper<IdDataModel, Id> idMapper;

    public UserMapper(
            Mapper<NameDataModel, Name> nameMapper,
            Mapper<LocationDataModel, Location> locationMapper,
            Mapper<PictureDataModel, Picture> pictureMapper,
            Mapper<LoginDataModel, Login> loginMapper,
            Mapper<IdDataModel, Id> idMapper
    ) {
        this.nameMapper = nameMapper;
        this.locationMapper = locationMapper;
        this.pictureMapper = pictureMapper;
        this.loginMapper = loginMapper;
        this.idMapper = idMapper;
    }

    @Override
    public RandomUser map(RandomUserResult user) {
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
