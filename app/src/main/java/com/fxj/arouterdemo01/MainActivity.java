package com.fxj.arouterdemo01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends Activity implements View.OnClickListener{

    private final String tag=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.navigateToAppModule).setOnClickListener(this);
        findViewById(R.id.navigateToOtherModule).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.navigateToAppModule:
                Log.i(tag,"R.id.navigateToAppModule被点击了!");
                ARouter.getInstance().build("/app/AppActivity1").navigation();
                break;
            case R.id.navigateToOtherModule:
                Log.i(tag,"R.id.navigateToOtherModule被点击了!");
                ARouter.getInstance().build("/module01/Module1Activity1").navigation();
                break;
        }
    }
}
