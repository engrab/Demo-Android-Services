package com.example.androidservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String TAG = MyService.class.getName();

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: Called");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    downloadFile(i);
                    i++;
                }
            }
        }).start();

        return START_REDELIVER_INTENT;

    }

    private void downloadFile(int i) {
        try {
            Thread.sleep(1000);
            Log.d(TAG, "downloadFile: "+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: Called");
        super.onDestroy();
    }
}
