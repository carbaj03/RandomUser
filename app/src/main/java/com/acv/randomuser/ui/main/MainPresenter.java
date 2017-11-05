package com.acv.randomuser.ui.main;


import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.main.GetRandomUserError;
import com.acv.randomuser.domain.usecase.main.GetRandomUsers;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.UseCaseResult;
import com.acv.randomuser.executor.UseCaseExecution;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.decorator.Presenter;
import com.acv.randomuser.ui.model.RandomUserMapper;

import java.util.List;

public class MainPresenter extends Presenter<MainView> {
    private final AppViewInjector viewInjector;
    private final UseCaseInvoker invoker;
    private final MainView view;
    private final GetRandomUsers getRandomUsers;
    private final RandomUserMapper mapper;

    public MainPresenter(
            AppViewInjector viewInjector,
            UseCaseInvoker invoker,
            MainView view,
            GetRandomUsers getRandomUsers,
            RandomUserMapper mapper
    ) {
        super(viewInjector, view);
        this.viewInjector = viewInjector;
        this.invoker = invoker;
        this.view = view;
        this.getRandomUsers = getRandomUsers;
        this.mapper = mapper;
    }

    public void loadRandomUsers() {
        new UseCaseExecution<>(getRandomUsers)
                .result(new UseCaseResult<List<RandomUser>>() {
                    @Override
                    public void onResult(List<RandomUser> result) {
                        getView().showRandomUsers(mapper.map(result));
                    }
                })
                .error(GetRandomUserError.class, new UseCaseResult<UseCaseError>() {
                    @Override
                    public void onResult(UseCaseError result) {

                    }
                })
                .execute(invoker);
    }

}
