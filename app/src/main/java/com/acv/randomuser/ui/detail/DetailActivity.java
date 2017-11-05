package com.acv.randomuser.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.acv.randomuser.App;
import com.acv.randomuser.R;
import com.acv.randomuser.di.module.DetailModule;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.ui.common.BaseActivity;

import javax.inject.Inject;

public class DetailActivity extends BaseActivity {
    public static final String ID = "Id";

    @Inject
    protected DetailPresenter presenter;

    public static Intent getCallingIntent(@NonNull Activity context, Id id) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews(this);
        configToolbarBack();
        App.appComponent.plus(new DetailModule(this)).inject(this);
        presenter.loadDetailRandomUser(getId());
    }

    private Id getId() {
        return (Id) getIntent().getSerializableExtra(ID);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }


}
