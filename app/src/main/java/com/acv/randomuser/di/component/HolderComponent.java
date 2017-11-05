package com.acv.randomuser.di.component;


import com.acv.randomuser.di.module.HolderModule;
import com.acv.randomuser.di.scope.ActivityScope;
import com.acv.randomuser.ui.main.RandomUserViewHolder;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {HolderModule.class})
public interface HolderComponent {
    void inject(RandomUserViewHolder randomUserViewHolder);
}
