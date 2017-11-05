package com.acv.randomuser.di.component;


import com.acv.randomuser.di.module.DetailModule;
import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.ui.detail.DetailActivity;
import com.acv.randomuser.ui.detail.DetailPresenter;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {DetailModule.class})
public interface DetailComponent {
    void inject(DetailActivity activity);

    DetailPresenter getDetailPresenter();
}
