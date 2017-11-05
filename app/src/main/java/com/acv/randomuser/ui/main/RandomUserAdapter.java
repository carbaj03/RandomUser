package com.acv.randomuser.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acv.randomuser.R;
import com.acv.randomuser.ui.model.RandomUserModel;

import java.util.ArrayList;
import java.util.List;

class RandomUserAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {
    private List<RandomUserModel> randomUsers = new ArrayList<>();

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_random_user, parent, false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        RandomUserViewHolder randomUserViewHolder = holder;
        RandomUserModel randomUserModel = randomUsers.get(position);
        randomUserViewHolder.render(randomUserModel);
    }

    @Override
    public int getItemCount() {
        return randomUsers.size();
    }

    public void addAll(List<RandomUserModel> randomUsers) {
        this.randomUsers.addAll(randomUsers);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        this.randomUsers.remove(position);
        notifyItemRemoved(position);
    }
}
