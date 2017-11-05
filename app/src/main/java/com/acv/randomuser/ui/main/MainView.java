package com.acv.randomuser.ui.main;


import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.ui.decorator.View;
import com.acv.randomuser.ui.model.RandomUserModel;

import java.util.List;

import me.panavtec.threaddecoratedview.views.qualifiers.ThreadDecoratedView;

@ThreadDecoratedView
public interface MainView extends View {
    void showRandomUsers(List<RandomUserModel> randomUsers);

    void showError();

    void showErrorNetwork();

    void removeItem(int position);

    void navigateToDetail(Id id);
}
