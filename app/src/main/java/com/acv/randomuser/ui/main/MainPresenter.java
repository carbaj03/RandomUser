package com.acv.randomuser.ui.main;


import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.InternalUseCaseError;
import com.acv.randomuser.domain.usecase.NetworkUseCaseError;
import com.acv.randomuser.domain.usecase.main.DeleteRandomUserError;
import com.acv.randomuser.domain.usecase.main.GetRandomUserError;
import com.acv.randomuser.domain.usecase.main.GetRandomUsers;
import com.acv.randomuser.domain.usecase.main.SaveRandomUser;
import com.acv.randomuser.executor.UseCaseExecution;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.decorator.Presenter;
import com.acv.randomuser.ui.model.RandomUserMapper;

import java.util.List;

public class MainPresenter extends Presenter<MainView> {
    private final UseCaseInvoker invoker;
    private final GetRandomUsers getRandomUsers;
    private final SaveRandomUser saveRandomUser;
    private final RandomUserMapper mapper;
    private List<RandomUser> randomUsers;

    public MainPresenter(
            AppViewInjector viewInjector,
            UseCaseInvoker invoker,
            MainView view,
            GetRandomUsers getRandomUsers,
            SaveRandomUser saveRandomUser,
            RandomUserMapper mapper
    ) {
        super(viewInjector, view);
        this.invoker = invoker;
        this.getRandomUsers = getRandomUsers;
        this.saveRandomUser = saveRandomUser;
        this.mapper = mapper;
    }

    public void loadRandomUsers() {
        UseCaseExecution.create(getRandomUsers)
                .success(result -> {
                    randomUsers = result;
                    getView().showRandomUsers(mapper.map(result));
                })
                .error(GetRandomUserError.class, result -> getView().showError())
                .error(NetworkUseCaseError.class, result -> getView().showErrorNetwork())
                .execute(invoker);
    }

    public void checkRandomUser(final int position) {
        saveRandomUser.setRandomUser(randomUsers.get(position));
        UseCaseExecution.create(saveRandomUser)
                .success(result -> getView().navigateToDetail(result.get(0).getId()))
                .error(DeleteRandomUserError.class, result -> getView().showError())
                .error(InternalUseCaseError.class, result -> getView().showError())
                .execute(invoker);

    }
}
