package com.acv.randomuser.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.acv.randomuser.App;
import com.acv.randomuser.R;
import com.acv.randomuser.di.module.MainModule;
import com.acv.randomuser.ui.RandomUserAdapter;
import com.acv.randomuser.ui.model.RandomUserModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{
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
        presenter.loadRandomUsers();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Random Users");
    }

    private void initRecyclerView() {
        adapter = new RandomUserAdapter();
        rvRandomUser.setAdapter(adapter);
        rvRandomUser.setLayoutManager(new LinearLayoutManager(this));
        rvRandomUser.setHasFixedSize(true);
    }

    @Override
    public void showRandomUsers(List<RandomUserModel> randomUsers) {
        adapter.addAll(randomUsers);
        adapter.notifyDataSetChanged();
    }
}
