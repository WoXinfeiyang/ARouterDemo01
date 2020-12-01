package com.fxj.arouterdemo01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fxj.arouterdemo01.service.HelloService;
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
                HelloService hellServiceByType= (HelloService) ARouter.getInstance().navigation(HelloService.class);
                if(hellServiceByType!=null){
                    Log.d(tag,"通过ByType获取Service不为空,");
                    hellServiceByType.sayHello("mike");
                }else{
                    Log.d(tag,"通过ByType获取Service为空");
                }
                break;
            case R.id.getServiceByName:
                HelloService hellServiceByName= (HelloService) ARouter.getInstance().build("/HelloService/HelloServiceImp01").navigation();
                if(hellServiceByName!=null){
                    Log.d(tag,"通过ByName获取Service不为空");
                    hellServiceByName.sayHello("Tom");
                }else{
                    Log.d(tag,"通过ByName获取Service为空");
                }
                break;

            case R.id.replacePath:
                Log.d(tag,"动态修改路由机制按钮被点击了!");
                ARouter.getInstance().build("/app/AppActivity2").navigation();
                break;
            case R.id.degrade:
                Log.d(tag,"跳转失败降级");
                ARouter.getInstance().build("/xx/xx").navigation();
                break;
        }
    }
}
