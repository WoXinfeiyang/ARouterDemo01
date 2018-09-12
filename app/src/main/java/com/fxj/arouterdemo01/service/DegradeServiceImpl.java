package com.fxj.arouterdemo01.service;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/app/service/DegradeServiceImpl")
public class DegradeServiceImpl implements DegradeService {

    private final String tag=DegradeServiceImpl.class.getSimpleName();

    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.d(tag,"**DegradeServiceImpl.onLost**");
        ARouter.getInstance().build("/app/AppActivity1").navigation();
    }

    @Override
    public void init(Context context) {

    }
}
