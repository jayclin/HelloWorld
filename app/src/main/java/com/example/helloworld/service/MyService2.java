package com.example.helloworld.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService2 extends Service {
    private final String TAG="MyService2";
    private int count;
    private boolean quit;
    private MyBinder binder=new MyBinder();

    public class MyBinder extends Binder{
        public int getCount(){
            return count;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!quit){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }).start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit=true;
        Log.e(TAG,"onDestroy");
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG,"onRebind");
    }
}
