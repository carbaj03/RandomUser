package com.acv.randomuser.ui.decorator;


public abstract class Presenter<V extends View> {

    private AppViewInjector appViewInjector;
    private V view;

    public Presenter(AppViewInjector appViewInjector, V view) {
        this.appViewInjector = appViewInjector;
        this.view = appViewInjector.injectView(view);
    }

    public void detachView() {
        this.view = appViewInjector.nullObjectPatternView(view);
    }

    public V getView() {
        return view;
    }

}