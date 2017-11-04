package com.acv.randomuser.di.module;


import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.ui.MainActivity;
import com.acv.randomuser.ui.MainPresenter;
import com.acv.randomuser.ui.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule extends ActivityModule {
    public MainModule(MainActivity activity) {
        super(activity);
    }

    @Provides
    @ActivityScope
    public MainPresenter provideMainPresenter(MainView view) {
        return new MainPresenter(view);
    }

    @ActivityScope
    @Provides
    public MainView provideView() {
        return (MainView) activity;
    }
}
