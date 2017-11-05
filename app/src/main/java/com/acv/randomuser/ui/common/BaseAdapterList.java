package com.acv.randomuser.ui.common;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract public class BaseAdapterList<T> extends RecyclerView.Adapter<BaseListViewHolder> {

    protected ItemClickListener itemClickListener;

    protected List<T> data;

    public BaseAdapterList() {
        this.data = new ArrayList<>();
    }

    public void addAll(List<T> newData){
        int posistionStart = data.size();
        data.addAll(newData);
        notifyItemRangeInserted(posistionStart, data.size());
    }

    public <L extends ItemClickListener> void setListener(L itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract T getItem(int position);

    public abstract List<T> getItems();

    public abstract void set(List<T> data);

    protected View inflate(ViewGroup parent, int layout) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }

    protected void validateCollection(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    public void removeItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
}