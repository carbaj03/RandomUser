package com.acv.randomuser.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.acv.randomuser.App;
import com.acv.randomuser.R;
import com.acv.randomuser.di.module.DetailModule;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.ui.common.BaseActivity;
import com.acv.randomuser.ui.common.ImageLoader;
import com.acv.randomuser.ui.model.RandomUserDetailModel;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailActivity extends BaseActivity implements DetailView{
    public static final String ID = "Id";

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvGender)
    TextView tvGender;
    @BindView(R.id.tvLocation)
    TextView tvLocation;
    @BindView(R.id.tvRegisterDate)
    TextView tvRegisterDate;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.ivPicture)
    ImageView ivPicture;

    @Inject
    protected DetailPresenter presenter;
    @Inject
    protected ImageLoader loader;

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

    @Override
    public void showRamdonUser(RandomUserDetailModel randomUser) {
        loader.loadCircle(randomUser.getThumbPicture(), ivPicture);
        tvName.setText(randomUser.getFullName());
        tvGender.setText(randomUser.getGender());
        tvLocation.setText(randomUser.getFullLocation());
        tvRegisterDate.setText(randomUser.getRegisterDate());
        tvEmail.setText(randomUser.getEmail());
    }
}
