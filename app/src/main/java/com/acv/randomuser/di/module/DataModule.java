package com.acv.randomuser.di.module;

import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    public RandomUserRepository provideRandomUserRepository(RandomUserNetwork network) {
        return new RandomUserRepository(network);
    }

    @Provides
    @Singleton
    public RandomUserNetwork provideRandomUserNetwork(){
        return new RandomUserNetwork() {
            @Override
            public List<RandomUser> obtainAllRandomUsers() {
                return null;
            }
        };
    }

//    @Provides
//    @Singleton
//    public RandomUserNetwork provideRandomUserGateway(
//            ApiClient apiClient,
//            Mapper<RandomUserResult, RandomUser> mapper
//    ) {
//        return new RandomUserRetrofit(apiClient, mapper);
//    }
}
