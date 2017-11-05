package com.acv.randomuser.di.module;

import com.acv.randomuser.RandomUserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    public RandomUserRepository provideRandomUserRepository() {
        return new RandomUserRepository();
    }
}
