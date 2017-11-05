package com.acv.randomuser.di.module;

import com.acv.randomuser.di.qualifiers.BackThread;
import com.acv.randomuser.di.qualifiers.SameThread;
import com.acv.randomuser.di.qualifiers.UiThread;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.decorator.AppViewInjectorImpl;
import com.acv.randomuser.ui.decorator.outputs.BackThreadSpec;
import com.acv.randomuser.ui.decorator.outputs.MainThreadSpec;
import com.acv.randomuser.ui.decorator.outputs.SameThreadSpec;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.panavtec.threaddecoratedview.views.ThreadSpec;

@Module
public class ThreadModule {
    @Provides
    @Singleton
    public AppViewInjector provideAppViewInjector(@UiThread ThreadSpec threadSpec) {
        return new AppViewInjectorImpl(threadSpec);
    }

    @Provides
    @Singleton
    @UiThread
    public ThreadSpec provideMainThread() {
        return new MainThreadSpec();
    }

    @Provides
    @Singleton
    @SameThread
    public ThreadSpec provideSameThread() {
        return new SameThreadSpec();
    }

    @Provides
    @Singleton
    @BackThread
    public ThreadSpec provideBackThread() {
        return new BackThreadSpec();
    }
}
