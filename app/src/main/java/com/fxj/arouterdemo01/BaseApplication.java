package com.fxj.arouterdemo01;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by AndyFu on 2018/9/8.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouterInit();
    }

    private void ARouterInit(){
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
