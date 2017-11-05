package com.acv.randomuser.ui.main;


import com.acv.randomuser.domain.GetRandomUsers;
import com.acv.randomuser.domain.UseCaseResponse;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.ui.model.RandomUserMapper;

import java.util.List;

public class MainPresenter {
    private MainView view;
    private GetRandomUsers getRandomUsers;
    private RandomUserMapper mapper;

    public MainPresenter(MainView view, GetRandomUsers getRandomUsers, RandomUserMapper mapper) {
        this.view = view;
        this.getRandomUsers = getRandomUsers;
        this.mapper = mapper;
    }

    public void loadRandomUsers() {
        UseCaseResponse<List<RandomUser>> call = getRandomUsers.call();
        view.showRandomUsers(mapper.map(call.getResult()));
    }

}
