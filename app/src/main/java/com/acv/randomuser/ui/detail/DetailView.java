package com.acv.randomuser.ui.detail;


import com.acv.randomuser.ui.decorator.View;
import com.acv.randomuser.ui.model.RandomUserDetailModel;

import me.panavtec.threaddecoratedview.views.qualifiers.ThreadDecoratedView;

@ThreadDecoratedView
public interface DetailView extends View {
    void showRamdonUser(RandomUserDetailModel randomUserDetailModel);
}
