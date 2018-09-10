package com.fxj.arouterdemo01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends Activity{

    private final String tag=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickHandler(View v){
        switch (v.getId()){
            case R.id.navigateToAppModule:
                Log.i(tag,"R.id.navigateToAppModule被点击了!");
                ARouter.getInstance().build("/app/AppActivity1").navigation(this, new NavCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        // Do nothing
                        Log.i(tag,"**onFound**"+postcard.toString());
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        // Do nothing
                        Log.i(tag,"**onFound**"+postcard.toString());
                    }


                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.i(tag,"**onFound**"+postcard.toString());
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        // Do nothing
                        Log.i(tag,"**onFound**"+postcard.toString());
                    }


                });
                break;
            case R.id.navigateToOtherModule:
                Log.i(tag,"R.id.navigateToOtherModule被点击了!");
                ARouter.getInstance().build("/module01/Module1Activity1").navigation();
                break;
        }
    }
}
