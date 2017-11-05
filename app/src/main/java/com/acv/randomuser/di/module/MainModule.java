package com.acv.randomuser.di.module;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.domain.GetRandomUsers;
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
            MainView view,
            GetRandomUsers getRandomUsers,
            RandomUserMapper mapper
    ) {
        return new MainPresenter(view, getRandomUsers, mapper);
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
}
