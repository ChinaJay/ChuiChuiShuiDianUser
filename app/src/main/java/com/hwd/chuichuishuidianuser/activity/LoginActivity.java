package com.hwd.chuichuishuidianuser.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hwd.chuichuishuidianuser.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Gary on 2017/9/5.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.et_pass)
    EditText et_pass;
    @BindView(R.id.eyy)
    ImageView eyy;
    @BindView(R.id.userRegister)
    TextView userRegister;
    @BindView(R.id.changePass)
    TextView changePass;
    @BindView(R.id.button)
    Button button;
    //是否长按
    boolean longClicked = false;


    @Override
    protected int getLayoutId() {

        return R.layout.activity_login;
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
        eyy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                longClicked =true;
                eyy.setImageResource(R.mipmap.eye_on);
                et_pass.setInputType(InputType.TYPE_CLASS_NUMBER);
                return false;
            }
        });
        eyy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP ) {
                    longClicked =false;
                    eyy.setImageResource(R.mipmap.eye_off);
                    et_pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                return false;
            }
        });

    }

    @OnClick({R.id.eyy,R.id.userRegister,R.id.changePass,R.id.button})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eyy:
                longClicked =true;
                eyy.setImageResource(R.mipmap.eye_on);
                et_pass.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case R.id.userRegister:
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.changePass:
                Intent intent1 =new Intent(LoginActivity.this,ChangePassActivity.class);
                startActivity(intent1);
                break;
            case R.id.button:
                Intent intent2 =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent2);
                break;
        }
    }


}
