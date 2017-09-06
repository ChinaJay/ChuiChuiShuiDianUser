package com.hwd.chuichuishuidianuser.activity;

import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hwd.chuichuishuidianuser.R;
import com.hwd.chuichuishuidianuser.utils.PubFunction;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Gary on 2017/9/5.
 */

public class ChangePassActivity extends BaseActivity implements View.OnClickListener {

    ImageView back;
    @BindView(R.id.tittle)
    TextView tittle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_changepass;
    }

    @Override
    protected void initView() {
        tittle.setText("修改密码");
    }

    @Override
    protected void initData() {
        initState();
    }

    /**
     * 动态的设置状态栏  实现沉浸式状态栏
     */
    private void initState() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            LinearLayout linear_bar = (LinearLayout) findViewById(R.id.ll_bar);
            linear_bar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = PubFunction.getStatusBarHeight(this);
            //动态的设置隐藏布局的高度
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) linear_bar.getLayoutParams();
            params.height = statusHeight;
            linear_bar.setLayoutParams(params);
        }
    }

    @OnClick({R.id.back})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
