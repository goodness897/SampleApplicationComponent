package com.example.tacademy.sampleapplicationcomponent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static final String TAG = "MainActivity";
    boolean isRunning = true;
    int count = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate() 호출", Toast.LENGTH_LONG).show();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while(isRunning) {
                    Log.i(TAG, "count : " + count);
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand() 호출", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy() 호출", Toast.LENGTH_LONG).show();
        isRunning = false;
    }
}
