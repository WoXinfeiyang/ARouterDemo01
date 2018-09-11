package com.fxj.module02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fxj.module01.routerService.Service1;
@Route(path = "/module02/Module2Activity1")
public class Module2Activity1 extends Activity {
    private final String tag=Module2Activity1.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module2_activity1);
    }

    public void onClickHandler(View v){
        if(v.getId()==R.id.module2_getService_ByType){
            Service1 service1ByType= ARouter.getInstance().navigation(Service1.class);
            if(service1ByType!=null){
                Log.d(tag,"通过ByType获取Service不为空,service1ByType.getInfo()="+service1ByType.getInfo());
            }else{
                Log.d(tag,"通过ByType获取Service为空");
            }
        }
    }
}
