package com.acv.randomuser.di.module;


import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.domain.GetRandomUsers;
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
    public MainPresenter provideMainPresenter(
            MainView view,
            GetRandomUsers getRandomUsers
    ) {
        return new MainPresenter(view, getRandomUsers);
    }

    @ActivityScope
    @Provides
    public MainView provideView() {
        return (MainView) activity;
    }

    @Provides
    @ActivityScope
    public GetRandomUsers provideGetRandomUsers() {
        return new GetRandomUsers();
    }
}
