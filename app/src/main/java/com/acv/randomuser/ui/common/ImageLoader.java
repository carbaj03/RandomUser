package com.acv.randomuser.ui.common;

import android.widget.ImageView;

public interface ImageLoader {
    void load(String url, ImageView view);
    void loadCircle(String url, ImageView view);
}
