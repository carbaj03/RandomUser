package com.acv.randomuser.ui.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseListViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected ItemClickListener itemClickListener;

    public BaseListViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        itemView.setOnClickListener(this);
    }

    public abstract void render(T item);

    @Override
    public void onClick(View view) {
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Context getContext(){
        return itemView.getContext().getApplicationContext();
    }
}