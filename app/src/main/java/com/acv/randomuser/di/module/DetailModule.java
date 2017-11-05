package com.acv.randomuser.di.module;


import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.detail.DetailActivity;
import com.acv.randomuser.ui.detail.DetailPresenter;
import com.acv.randomuser.ui.detail.DetailView;

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
            DetailView view
    ) {
        return new DetailPresenter(appViewInjector, invoker, view);
    }

    @ActivityScope
    @Provides
    public DetailView provideView() {
        return (DetailView) activity;
    }


}
