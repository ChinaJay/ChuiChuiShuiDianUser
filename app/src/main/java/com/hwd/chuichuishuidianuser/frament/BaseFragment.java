package com.hwd.chuichuishuidianuser.frament;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * User: quanwen
 * Date: 2017-08-08
 * Time: 12:02
 * Description:
 */

public class BaseFragment extends Fragment {

    public  Context context;

    public void Toast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

}
