package com.fxj.arouterdemo01.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path="/HelloService/HelloServiceImp01")
public class HelloServiceImp01 implements HelloService {
    Context mContext;
    @Override
    public void sayHello(String name) {
        Toast.makeText(mContext,HelloServiceImp01.class.getSimpleName()+"say hello to"+name,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.mContext=context;
    }
}
