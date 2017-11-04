package com.acv.randomuser.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.acv.randomuser.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rvRandomUser)
    RecyclerView rvRandomUser;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private RandomUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        ButterKnife.bind(this);

        initToolbar();
        initRecyclerView();
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


}
