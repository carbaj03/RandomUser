package com.acv.randomuser.ui.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.acv.randomuser.App;
import com.acv.randomuser.R;
import com.acv.randomuser.di.module.HolderModule;
import com.acv.randomuser.ui.common.BaseListViewHolder;
import com.acv.randomuser.ui.common.ImageLoader;
import com.acv.randomuser.ui.common.ItemClickListener;
import com.acv.randomuser.ui.model.RandomUserModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomUserViewHolder extends BaseListViewHolder<RandomUserModel> {

    @BindView(R.id.ivPicture)
    ImageView ivPicture;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvCity)
    TextView tvCity;
    @BindView(R.id.tvPhone)
    TextView tvPhone;

    @Inject
    protected ImageLoader loader;

    public RandomUserViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView, itemClickListener);
        ButterKnife.bind(this, itemView);
        App.appComponent.plus(new HolderModule()).inject(this);
    }

    @Override
    public void render(RandomUserModel randomUser) {
        loader.loadCircle(randomUser.getPicture(), ivPicture);
        tvName.setText(randomUser.getFullName());
        tvCity.setText(randomUser.getCity());
        tvPhone.setText(randomUser.getPhone());
    }

}