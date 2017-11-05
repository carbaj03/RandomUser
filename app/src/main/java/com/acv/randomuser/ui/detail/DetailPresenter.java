package com.acv.randomuser.ui.detail;


import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.decorator.Presenter;

public class DetailPresenter extends Presenter<DetailView> {
    private UseCaseInvoker invoker;

    public DetailPresenter(
            AppViewInjector viewInjector,
            UseCaseInvoker invoker,
            DetailView view) {
        super(viewInjector, view);
        this.invoker = invoker;
    }


}
