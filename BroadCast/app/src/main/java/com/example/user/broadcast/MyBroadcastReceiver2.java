package com.example.user.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by USER on 2017/11/9.
 */

public class MyBroadcastReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String sender = intent.getStringExtra("semder_name");
        Toast.makeText(context, "BroadCastReciver2 收到" + sender + "發送的Broadcas", Toast.LENGTH_LONG).show();
    }
}