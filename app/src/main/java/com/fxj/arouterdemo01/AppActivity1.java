package com.fxj.arouterdemo01;

import android.os.Bundle;
import android.app.Activity;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/app/AppActivity1")
public class AppActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app1);
    }

}
