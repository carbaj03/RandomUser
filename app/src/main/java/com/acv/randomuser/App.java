package com.acv.randomuser;


import android.app.Application;

import com.acv.randomuser.di.component.AppComponent;
import com.acv.randomuser.di.component.DaggerAppComponent;
import com.acv.randomuser.di.module.AppModule;

public class App extends Application {
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initializeDagger();
    }

    private AppComponent initializeDagger() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public void setAppComponent(AppComponent appComponent) {
        App.appComponent = appComponent;
    }
}
