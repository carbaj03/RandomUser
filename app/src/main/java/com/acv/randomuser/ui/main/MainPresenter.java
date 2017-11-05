package com.acv.randomuser.ui.main;


import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.InternalUseCaseError;
import com.acv.randomuser.domain.usecase.NetworkUseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResult;
import com.acv.randomuser.domain.usecase.main.DeleteRandomUser;
import com.acv.randomuser.domain.usecase.main.DeleteRandomUserError;
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
    private final DeleteRandomUser deleteRandomUser;
    private final RandomUserMapper mapper;
    private List<RandomUser> randomUsers;

    public MainPresenter(
            AppViewInjector viewInjector,
            UseCaseInvoker invoker,
            MainView view,
            GetRandomUsers getRandomUsers,
            DeleteRandomUser deleteRandomUser, RandomUserMapper mapper
    ) {
        super(viewInjector, view);
        this.invoker = invoker;
        this.getRandomUsers = getRandomUsers;
        this.deleteRandomUser = deleteRandomUser;
        this.mapper = mapper;
    }

    public void loadRandomUsers() {
        UseCaseExecution.create(getRandomUsers)
                .success(new UseCaseResult<List<RandomUser>>() {
                    @Override
                    public void onResult(List<RandomUser> result) {
                        randomUsers = result;
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

    public void removeRandomUser(final int position) {
        deleteRandomUser.setRandomUser(randomUsers.get(position));
        UseCaseExecution.create(deleteRandomUser)
                .success(new UseCaseResult<Boolean>() {
                    @Override
                    public void onResult(Boolean result) {
                        randomUsers.remove(position);
                        getView().removeItem(position);
                    }
                })
                .error(DeleteRandomUserError.class, new UseCaseResult<GetRandomUserError>() {
                    @Override
                    public void onResult(GetRandomUserError result) {
                        getView().showError();
                    }
                })
                .error(InternalUseCaseError.class, new UseCaseResult<InternalUseCaseError>() {
                    @Override
                    public void onResult(InternalUseCaseError result) {
                        getView().showError();
                    }
                })
                .execute(invoker);
    }

    public void checkRandomUser(int position) {
        getView().navigateToDetail(randomUsers.get(position).getId());
    }
}
