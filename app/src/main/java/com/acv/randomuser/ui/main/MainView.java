package com.acv.randomuser.ui.main;


import com.acv.randomuser.ui.model.RandomUserModel;

import java.util.List;

public interface MainView {
    void showRandomUsers(List<RandomUserModel> randomUsers);
}
