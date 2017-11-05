package com.acv.randomuser.ui.common;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.acv.randomuser.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected TextView tvToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    public abstract int getLayout();

    public <T extends Activity> void bindViews(T activity){
        ButterKnife.bind(activity);
    }

    protected void configToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void configToolbarBack() {
        configToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    }

    protected void initToolbar(String title) {
        configToolbar();
        getSupportActionBar().setTitle(R.string.main_title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK ) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }
}
