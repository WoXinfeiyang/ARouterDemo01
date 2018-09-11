package com.fxj.arouterdemo01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fxj.module01.routerService.Service1;

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
                ARouter.getInstance().build("/module02/Module2Activity1").navigation();
                break;

            case R.id.getServiceByType:
                Service1 service1ByType= ARouter.getInstance().navigation(Service1.class);
                if(service1ByType!=null){
                    Log.d(tag,"通过ByType获取Service不为空,service1ByType.getInfo()="+service1ByType.getInfo());
                }else{
                    Log.d(tag,"通过ByType获取Service为空");
                }
                break;
            case R.id.getServiceByName:
                Service1 service1ByName= ARouter.getInstance().navigation(Service1.class);
                if(service1ByName!=null){
                    Log.d(tag,"通过ByName获取Service不为空,service1ByName.getInfo()="+service1ByName.getInfo());
                }else{
                    Log.d(tag,"通过ByName获取Service为空");
                }
                break;
        }
    }
}
