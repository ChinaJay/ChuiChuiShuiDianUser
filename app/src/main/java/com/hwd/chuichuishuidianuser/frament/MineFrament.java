package com.hwd.chuichuishuidianuser.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwd.chuichuishuidianuser.R;

/**
 * Created by Gary on 2017/9/5.
 */

public class MineFrament extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_mine, container, false);
        initView(view);
        return view;
    }
    private void initView(View view)
    {

    }

}
