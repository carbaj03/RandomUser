package com.acv.randomuser.ui.main;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.acv.randomuser.App;
import com.acv.randomuser.R;
import com.acv.randomuser.di.module.MainModule;
import com.acv.randomuser.ui.common.SwipeToDelete;
import com.acv.randomuser.ui.model.RandomUserModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.rvRandomUser)
    RecyclerView rvRandomUser;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    protected MainPresenter presenter;

    private RandomUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.appComponent.plus(new MainModule(this)).inject(this);

        initToolbar();
        initRecyclerView();
        initSwipeDelete();
        presenter.loadRandomUsers();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.main_title);
    }

    private void initRecyclerView() {
        adapter = new RandomUserAdapter();
        rvRandomUser.setAdapter(adapter);
        rvRandomUser.setLayoutManager(new LinearLayoutManager(this));
        rvRandomUser.setHasFixedSize(true);
    }

    private void initSwipeDelete() {
        SwipeToDelete swipeToDelete = new SwipeToDelete(rvRandomUser, new SwipeToDelete.Callback() {
            @Override
            public void onRemove(int position) {

            }
        });
        swipeToDelete.init();
    }

    @Override
    public void showRandomUsers(List<RandomUserModel> randomUsers) {
        adapter.addAll(randomUsers);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        Snackbar.make(rvRandomUser, R.string.error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorNetwork() {
        Snackbar.make(rvRandomUser, R.string.error_network, Snackbar.LENGTH_SHORT).show();
    }
}
