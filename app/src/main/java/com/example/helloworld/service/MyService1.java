package com.example.helloworld.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService1 extends Service {
    private final String TAG="MyService";

    //必须实现的方法
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind方法被调用");
        return null;
    }

    //service被创建时调用
    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate方法被调用");
        super.onCreate();
    }
    //service启动时被调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand方法被调用");
        return super.onStartCommand(intent, flags, startId);
    }
    //service被关闭之前回调
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy方法被调用");
    }
}
