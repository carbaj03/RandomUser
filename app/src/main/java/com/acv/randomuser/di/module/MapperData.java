package com.acv.randomuser.di.module;

import com.acv.randomuser.data.local.mapper.IdLocalMapper;
import com.acv.randomuser.data.local.mapper.LocationLocalMapper;
import com.acv.randomuser.data.local.mapper.LoginLocalMapper;
import com.acv.randomuser.data.local.mapper.NameLocalMapper;
import com.acv.randomuser.data.local.mapper.PictureLocalMapper;
import com.acv.randomuser.data.local.mapper.RandomDeleteUserLocalMapper;
import com.acv.randomuser.data.local.mapper.RandomUserLocalMapper;
import com.acv.randomuser.data.local.model.IdLocalModel;
import com.acv.randomuser.data.local.model.LocationLocalModel;
import com.acv.randomuser.data.local.model.LoginLocalModel;
import com.acv.randomuser.data.local.model.NameLocalModel;
import com.acv.randomuser.data.local.model.PictureLocalModel;
import com.acv.randomuser.data.network.RandomUserResult;
import com.acv.randomuser.data.network.mapper.IdMapper;
import com.acv.randomuser.data.network.mapper.LocationMapper;
import com.acv.randomuser.data.network.mapper.LoginMapper;
import com.acv.randomuser.data.network.mapper.NameMapper;
import com.acv.randomuser.data.network.mapper.PictureMapper;
import com.acv.randomuser.data.network.mapper.UserMapper;
import com.acv.randomuser.data.network.model.IdDataModel;
import com.acv.randomuser.data.network.model.LocationDataModel;
import com.acv.randomuser.data.network.model.LoginDataModel;
import com.acv.randomuser.data.network.model.NameDataModel;
import com.acv.randomuser.data.network.model.PictureDataModel;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.mapper.TwoWaysMapper;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.Location;
import com.acv.randomuser.domain.model.Login;
import com.acv.randomuser.domain.model.Name;
import com.acv.randomuser.domain.model.Picture;
import com.acv.randomuser.domain.model.RandomUser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperData {

    @Provides
    @Singleton
    Mapper<RandomUserResult, RandomUser> provideUserMapper(
            Mapper<LocationDataModel, Location> locationMapper,
            Mapper<NameDataModel, Name> nameMapper,
            Mapper<PictureDataModel, Picture> pictureMapper,
            Mapper<LoginDataModel, Login> loginMapper,
            Mapper<IdDataModel, Id> idMapper
    ) {
        return new UserMapper(nameMapper, locationMapper, pictureMapper, loginMapper, idMapper);
    }

    @Provides
    @Singleton
    Mapper<LocationDataModel, Location> provideLocationMapper() {
        return new LocationMapper();
    }

    @Provides
    @Singleton
    Mapper<NameDataModel, Name> provideNameMapper() {
        return new NameMapper();
    }

    @Provides
    @Singleton
    Mapper<PictureDataModel, Picture> providePictureMapper() {
        return new PictureMapper();
    }

    @Provides
    @Singleton
    Mapper<IdDataModel, Id> provideIdMapper() {
        return new IdMapper();
    }

    @Provides
    @Singleton
    Mapper<LoginDataModel, Login> provideLoginMapper() {
        return new LoginMapper();
    }




    @Provides
    @Singleton
    RandomUserLocalMapper provideRandomUserLocalMapper(
            TwoWaysMapper<LocationLocalModel, Location> locationMapper,
            TwoWaysMapper<NameLocalModel, Name> nameMapper,
            TwoWaysMapper<PictureLocalModel, Picture> pictureMapper,
            TwoWaysMapper<LoginLocalModel, Login> loginMapper,
            TwoWaysMapper<IdLocalModel, Id> idMapper
    ) {
        return new RandomUserLocalMapper(nameMapper, locationMapper, pictureMapper, loginMapper, idMapper);
    }

    @Provides
    @Singleton
    TwoWaysMapper<LocationLocalModel, Location> provideLocationLocalMapper() {
        return new LocationLocalMapper();
    }

    @Provides
    @Singleton
    TwoWaysMapper<NameLocalModel, Name> provideNameLocalMapper() {
        return new NameLocalMapper();
    }

    @Provides
    @Singleton
    TwoWaysMapper<PictureLocalModel, Picture> providePictureLocalMapper() {
        return new PictureLocalMapper();
    }

    @Provides
    @Singleton
    TwoWaysMapper<IdLocalModel, Id> provideIdLocalMapper() {
        return new IdLocalMapper();
    }

    @Provides
    @Singleton
    TwoWaysMapper<LoginLocalModel, Login> provideLoginLocalMapper() {
        return new LoginLocalMapper();
    }

    @Provides
    @Singleton
    RandomDeleteUserLocalMapper provideRandomDeleteUserLocalMapper(
            TwoWaysMapper<LocationLocalModel, Location> locationMapper,
            TwoWaysMapper<NameLocalModel, Name> nameMapper,
            TwoWaysMapper<PictureLocalModel, Picture> pictureMapper,
            TwoWaysMapper<LoginLocalModel, Login> loginMapper,
            TwoWaysMapper<IdLocalModel, Id> idMapper
    ) {
        return new RandomDeleteUserLocalMapper(nameMapper, locationMapper, pictureMapper, loginMapper, idMapper);
    }
}
