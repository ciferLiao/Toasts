package com.example.myapplication;

import android.app.Application;

/**
 * 文件描述：
 * 作者：ciferLiao
 * 创建时间：2019/4/15
 * 更改时间：2019/4/15
 * 版本号：1
 */

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.init(this);
    }
}
