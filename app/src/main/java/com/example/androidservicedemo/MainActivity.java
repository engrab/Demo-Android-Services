package com.example.androidservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View v) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }

}
