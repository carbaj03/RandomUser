package com.acv.randomuser.di.component;

import com.acv.randomuser.di.module.AppModule;
import com.acv.randomuser.di.module.DataModule;
import com.acv.randomuser.di.module.DomainModule;
import com.acv.randomuser.di.module.HolderModule;
import com.acv.randomuser.di.module.MainModule;
import com.acv.randomuser.ui.common.ImageLoader;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        DataModule.class,
        DomainModule.class
})
public interface AppComponent {
    MainComponent plus(MainModule module);
    HolderComponent plus(HolderModule holderModule);

    ImageLoader getImageLoader();
}
