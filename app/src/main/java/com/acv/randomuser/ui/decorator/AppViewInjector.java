package com.acv.randomuser.ui.decorator;

public interface AppViewInjector {
    <V> V injectView(V view);
    <V> V nullObjectPatternView(V view);
}