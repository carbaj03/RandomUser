package com.acv.randomuser.di.module;


import android.content.Context;

import com.acv.randomuser.App;
import com.acv.randomuser.ui.common.GlideLoader;
import com.acv.randomuser.ui.common.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule extends ThreadModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application.getApplicationContext();
    }

    @Provides
    @Singleton
    public RequestManager provideRequestManager(Context context) {
        return Glide.with(context);
    }

    @Provides
    @Singleton
    public ImageLoader provideImageLoader(GlideLoader glideLoader) {
        return glideLoader;
    }


}
