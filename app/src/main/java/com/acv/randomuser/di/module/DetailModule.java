package com.acv.randomuser.di.module;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.domain.usecase.detail.GetRandomUserDetail;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.detail.DetailActivity;
import com.acv.randomuser.ui.detail.DetailPresenter;
import com.acv.randomuser.ui.detail.DetailView;
import com.acv.randomuser.ui.model.RandomUserDetailMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule extends ActivityModule {
    public DetailModule(DetailActivity activity) {
        super(activity);
    }

    @Provides
    @ActivityScope
    public DetailPresenter provideDetailPresenter(
            AppViewInjector appViewInjector,
            UseCaseInvoker invoker,
            GetRandomUserDetail getRandomUserDetail,
            DetailView view,
            RandomUserDetailMapper mapper
    ) {
        return new DetailPresenter(appViewInjector, invoker, getRandomUserDetail, view, mapper);
    }

    @ActivityScope
    @Provides
    public DetailView provideView() {
        return (DetailView) activity;
    }

    @Provides
    @ActivityScope
    public GetRandomUserDetail provideSaveRandomUser(RandomUserRepository localGateway) {
        return new GetRandomUserDetail(localGateway);
    }

    @Provides
    @ActivityScope
    public RandomUserDetailMapper provideRandomUserDetailMapper() {
        return new RandomUserDetailMapper();
    }
}
