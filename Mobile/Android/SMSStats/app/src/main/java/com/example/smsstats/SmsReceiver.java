package com.example.smsstats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent){
        final Intent intentNew = new Intent("SMS_ARRIVED");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intentNew);
    }
}
