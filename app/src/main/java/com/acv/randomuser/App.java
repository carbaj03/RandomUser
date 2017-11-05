package com.acv.randomuser;


import android.app.Application;

import com.acv.randomuser.data.local.DataBaseHelper;
import com.acv.randomuser.di.component.AppComponent;
import com.acv.randomuser.di.component.DaggerAppComponent;
import com.acv.randomuser.di.module.AppModule;

public class App extends Application {
    public static AppComponent appComponent;
    private DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initializeDagger();
        dataBaseHelper = initLocalStorage();
    }

    private AppComponent initializeDagger() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public void setAppComponent(AppComponent appComponent) {
        App.appComponent = appComponent;
    }

    public DataBaseHelper initLocalStorage(){
        if (dataBaseHelper == null){
            releaseLocalStorage();
        }
        return dataBaseHelper;
    }

    private void releaseLocalStorage(){
        dataBaseHelper = DataBaseHelper
                .createInstance(this)
                .initalize();
    }

}
