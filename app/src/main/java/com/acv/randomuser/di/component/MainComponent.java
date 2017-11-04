package com.acv.randomuser.di.component;


import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.di.module.MainModule;
import com.acv.randomuser.ui.MainActivity;
import com.acv.randomuser.ui.MainPresenter;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity activity);

    MainPresenter getMainPresenter();
}
