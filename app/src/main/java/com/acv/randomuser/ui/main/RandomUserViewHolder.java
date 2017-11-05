package com.acv.randomuser.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.acv.randomuser.App;
import com.acv.randomuser.R;
import com.acv.randomuser.di.module.HolderModule;
import com.acv.randomuser.ui.common.ImageLoader;
import com.acv.randomuser.ui.model.RandomUserModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomUserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.ivPicture)
    ImageView ivPicture;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.tvPhone)
    TextView tvPhone;

    @Inject
    protected ImageLoader loader;

    public RandomUserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        App.appComponent.plus(new HolderModule()).inject(this);
    }

    public void render(RandomUserModel randomUser) {
        loader.loadCircle(randomUser.getPicture(), ivPicture);
        tvName.setText(randomUser.getFullName());
        tvEmail.setText(randomUser.getEmail());
        tvPhone.setText(randomUser.getPhone());
    }

    @Override
    public void onClick(View view) {

    }
}