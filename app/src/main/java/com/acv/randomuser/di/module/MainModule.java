package com.acv.randomuser.di.module;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.domain.usecase.main.GetRandomUsers;
import com.acv.randomuser.domain.usecase.main.SaveRandomUser;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.main.MainActivity;
import com.acv.randomuser.ui.main.MainPresenter;
import com.acv.randomuser.ui.main.MainView;
import com.acv.randomuser.ui.model.RandomUserMapper;

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
            AppViewInjector appViewInjector,
            UseCaseInvoker invoker,
            MainView view,
            GetRandomUsers getRandomUsers,
            SaveRandomUser saveRandomUser,
            RandomUserMapper mapper
    ) {
        return new MainPresenter(appViewInjector, invoker, view, getRandomUsers, saveRandomUser, mapper);
    }

    @ActivityScope
    @Provides
    public MainView provideView() {
        return (MainView) activity;
    }

    @Provides
    @ActivityScope
    public GetRandomUsers provideGetRandomUsers(RandomUserRepository repository) {
        return new GetRandomUsers(repository);
    }

    @Provides
    @ActivityScope
    public RandomUserMapper provideRandomUserMapper() {
        return new RandomUserMapper();
    }

    @Provides
    @ActivityScope
    public SaveRandomUser provideSaveRandomUser(RandomUserRepository localGateway) {
        return new SaveRandomUser(localGateway);
    }
}
