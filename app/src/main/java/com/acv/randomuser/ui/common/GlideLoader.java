package com.acv.randomuser.ui.common;

import android.widget.ImageView;

import com.acv.randomuser.R;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


@Singleton
public class GlideLoader implements ImageLoader {
    private RequestManager glide;

    @Inject
    public GlideLoader(RequestManager glide) {
        this.glide = glide;
    }

    @Override
    public void load(String url, ImageView view) {
        glide.load(url).into(view);
    }

    @Override
    public void loadCircle(String url, ImageView view) {
        glide.load(url)
                .apply(bitmapTransform(new MultiTransformation(new CircleCrop(), new CenterCrop())))
                .into(view);
    }
}
