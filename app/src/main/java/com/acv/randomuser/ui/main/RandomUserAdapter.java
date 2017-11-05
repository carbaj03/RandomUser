package com.acv.randomuser.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acv.randomuser.R;
import com.acv.randomuser.ui.common.BaseAdapterList;
import com.acv.randomuser.ui.common.BaseListViewHolder;
import com.acv.randomuser.ui.model.RandomUserModel;

import java.util.ArrayList;
import java.util.List;

class RandomUserAdapter  extends BaseAdapterList<RandomUserModel> {

    @Override
    public RandomUserModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public List<RandomUserModel> getItems() {
        return data;
    }

    @Override
    public void set(List<RandomUserModel> randomUsers) {
        validateCollection(randomUsers);
        data = randomUsers;
        notifyDataSetChanged();
    }

    @Override
    public BaseListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RandomUserViewHolder(inflate(parent, viewType), itemClickListener);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_random_user;
    }

    @Override
    public void onBindViewHolder(BaseListViewHolder holder, int position) {
        holder.render(data.get(position));
    }
}
