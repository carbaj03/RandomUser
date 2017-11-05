package com.acv.randomuser.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.acv.randomuser.R;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.ui.common.BaseActivity;

public class DetailActivity extends BaseActivity {
    public static final String ID = "Id";
    
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
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }
}
