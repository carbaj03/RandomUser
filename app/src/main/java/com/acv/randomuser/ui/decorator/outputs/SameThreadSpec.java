package com.acv.randomuser.ui.decorator.outputs;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

public class SameThreadSpec implements ThreadSpec {

    @Override
    public void execute(Runnable action) {
        action.run();
    }
}
