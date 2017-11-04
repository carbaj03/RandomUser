package com.acv.randomuser.di;

import android.content.Context;

import com.acv.randomuser.App;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
}