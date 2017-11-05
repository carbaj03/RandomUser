package com.acv.randomuser.ui;


import com.acv.randomuser.domain.GetRandomUsers;
import com.acv.randomuser.domain.UseCaseResponse;

import java.util.List;

public class MainPresenter {
    private MainView view;
    private GetRandomUsers getRandomUsers;

    public MainPresenter(MainView view, GetRandomUsers getRandomUsers) {
        this.view = view;
        this.getRandomUsers = getRandomUsers;
    }

    public void loadRandomUsers() {
        UseCaseResponse<List<RandomUserModel>> call = getRandomUsers.call();
        view.showRandomUsers(call.getResult());
    }

}
