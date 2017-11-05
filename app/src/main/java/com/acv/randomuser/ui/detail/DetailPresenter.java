package com.acv.randomuser.ui.detail;


import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.UseCaseResult;
import com.acv.randomuser.domain.usecase.detail.GetRandomUserDetail;
import com.acv.randomuser.domain.usecase.main.GetRandomUserError;
import com.acv.randomuser.executor.UseCaseExecution;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.ui.decorator.AppViewInjector;
import com.acv.randomuser.ui.decorator.Presenter;

public class DetailPresenter extends Presenter<DetailView> {
    private final UseCaseInvoker invoker;
    private final GetRandomUserDetail getRandomUserDetail;

    public DetailPresenter(
            AppViewInjector viewInjector,
            UseCaseInvoker invoker,
            GetRandomUserDetail getRandomUserDetail,
            DetailView view
    ) {
        super(viewInjector, view);
        this.invoker = invoker;
        this.getRandomUserDetail = getRandomUserDetail;
    }

    public void loadDetailRandomUser(Id id) {
        getRandomUserDetail.setId(id);
        UseCaseExecution.create(getRandomUserDetail)
                .success(new UseCaseResult<RandomUser>() {
                    @Override
                    public void onResult(RandomUser result) {

                    }
                })
                .error(GetRandomUserError.class, new UseCaseResult<GetRandomUserError>() {
                    @Override
                    public void onResult(GetRandomUserError result) {

                    }
                }).execute(invoker);
    }
}
