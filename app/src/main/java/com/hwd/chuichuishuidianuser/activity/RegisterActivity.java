package com.hwd.chuichuishuidianuser.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hwd.chuichuishuidianuser.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Gary on 2017/9/5.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.userLogin)
    TextView userLogin;
    @BindView(R.id.eyy)
    ImageView eyy;
    @BindView(R.id.et_pass)
    EditText et_pass;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

    @Override
    protected void initData() {

    }
    @OnClick({R.id.eyy,R.id.userLogin,R.id.et_pass})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eyy:
                eyy.setImageResource(R.mipmap.eye_on);
                et_pass.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case R.id.userLogin:
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
