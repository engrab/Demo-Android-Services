package com.example.androidservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {
public static final String TAG = MyIntentService.class.getName();
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: ");
        String message = intent.getStringExtra(MainActivity.TEXT);
        downloadingFile();
    }

    private void downloadingFile() {
        try {
            int i = 1;
            while (i <= 10) {
                Thread.sleep(1000);
                Log.d(TAG, "downloadingFile: "+i);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
