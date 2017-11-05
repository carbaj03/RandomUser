package com.acv.randomuser.ui.main;


import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.NetworkUseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResult;
import com.acv.randomuser.domain.usecase.main.GetRandomUserError;
import com.acv.randomuser.domain.usecase.main.GetRandomUsers;
import com.acv.randomuser.executor.UseCaseExecution;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.decorator.Presenter;
import com.acv.randomuser.ui.model.RandomUserMapper;

import java.util.List;

public class MainPresenter extends Presenter<MainView> {
    private final UseCaseInvoker invoker;
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
        this.invoker = invoker;
        this.getRandomUsers = getRandomUsers;
        this.mapper = mapper;
    }

    public void loadRandomUsers() {
        UseCaseExecution.create(getRandomUsers)
                .success(new UseCaseResult<List<RandomUser>>() {
                    @Override
                    public void onResult(List<RandomUser> result) {
                        getView().showRandomUsers(mapper.map(result));
                    }
                })
                .error(GetRandomUserError.class, new UseCaseResult<UseCaseError>() {
                    @Override
                    public void onResult(UseCaseError result) {
                        getView().showError();
                    }
                })
                .error(NetworkUseCaseError.class, new UseCaseResult<UseCaseError>() {
                    @Override
                    public void onResult(UseCaseError result) {
                        getView().showErrorNetwork();
                    }
                })
                .execute(invoker);
    }

}
