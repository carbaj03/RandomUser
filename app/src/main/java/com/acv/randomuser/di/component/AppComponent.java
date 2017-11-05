package com.acv.randomuser.di.component;

import com.acv.randomuser.di.module.AppModule;
import com.acv.randomuser.di.module.DataModule;
import com.acv.randomuser.di.module.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        DataModule.class
})
public interface AppComponent {
    MainComponent plus(MainModule module);
}
