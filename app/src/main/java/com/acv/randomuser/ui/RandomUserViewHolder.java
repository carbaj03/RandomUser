package com.acv.randomuser.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RandomUserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected ItemClickListener itemClickListener;

    public RandomUserViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}