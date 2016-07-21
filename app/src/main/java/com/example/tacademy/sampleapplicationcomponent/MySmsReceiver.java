package com.example.tacademy.sampleapplicationcomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MySmsReceiver extends BroadcastReceiver {
    public MySmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context.getApplicationContext(), "SMS Received", Toast.LENGTH_LONG).show();
        context.startService(new Intent(context, MyService.class));

    }
}
