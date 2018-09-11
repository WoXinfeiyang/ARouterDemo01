package com.fxj.module01.routerService;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/module01/Service1Impl")
public class Service1Impl implements Service1 {


    @Override
    public String getInfo() {
        String msg="我是Service1Impl,当前系统时间:"+System.currentTimeMillis();
        return msg;
    }

    @Override
    public void init(Context context) {

    }
}
