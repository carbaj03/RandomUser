package com.acv.randomuser.ui;


import com.acv.randomuser.ui.decorator.AppViewInjector;

public class FakeViewInjector implements AppViewInjector {

    @Override
    public <V> V injectView(V view) {
        return view;
    }

    @Override
    public <V> V nullObjectPatternView(V view) {
        return view;
    }
}