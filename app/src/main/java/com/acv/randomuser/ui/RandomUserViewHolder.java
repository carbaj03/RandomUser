package com.acv.randomuser.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.acv.randomuser.R;

import java.util.Random;

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

    public RandomUserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void render(RandomUserModel randomUsers) {
        tvName.setText(randomUsers.getFullName());
        tvEmail.setText(randomUsers.getEmail());
        tvPhone.setText(randomUsers.getPhone());
    }

    @Override
    public void onClick(View view) {

    }
}