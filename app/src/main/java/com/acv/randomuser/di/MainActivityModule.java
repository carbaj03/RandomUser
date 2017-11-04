package com.acv.randomuser.di;


import com.acv.randomuser.ui.MainActivity;
import com.acv.randomuser.ui.MainPresenter;
import com.acv.randomuser.ui.MainPresenterI;
import com.acv.randomuser.ui.MainView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule extends ActivityModule {
    public MainActivityModule(MainActivity activity) {
        super(activity);
    }

    @Provides
    @ActivityScope
    public MainPresenter provideMainPresenter(
            MainView view
    ) {
        return new MainPresenter(view);
    }

    @ActivityScope
    @Provides
    public MainView provideView() {
        return (MainView) activity;
    }
}