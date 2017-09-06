package com.hwd.chuichuishuidianuser.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hwd.chuichuishuidianuser.utils.ProgressUtil;

import butterknife.ButterKnife;


/**
 * Created by Gary on 2016/12/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context context = this;
    private boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected void showLoading(String message) {
        if (context == null) {
            return;
        }
        ProgressUtil.show(this, message);
        isLoading = true;
    }

    protected void Toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showLoading() {
        if (context == null) {
            return;
        }
        ProgressUtil.show(this);
    }

    protected void dismissLoading() {
        if (context == null) {
            return;
        }
        ProgressUtil.dismiss();
        isLoading = false;
    }


}
