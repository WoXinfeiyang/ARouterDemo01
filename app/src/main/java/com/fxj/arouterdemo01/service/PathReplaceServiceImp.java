package com.fxj.arouterdemo01.service;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;

//@Route(path = "/app/PathReplaceServiceImp/")
public class PathReplaceServiceImp implements PathReplaceService {

    @Override
    public String forString(String path) {
        String replacePath=null;
        if(path.equals("/app/AppActivity2")){
            replacePath="/app/AppActivity1";
        }
        return replacePath;
    }

    @Override
    public Uri forUri(Uri uri) {
        return null;
    }

    @Override
    public void init(Context context) {

    }
}
