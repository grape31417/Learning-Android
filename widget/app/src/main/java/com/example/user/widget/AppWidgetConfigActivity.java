package com.example.user.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class AppWidgetConfigActivity extends AppCompatActivity {
    int mAppWidgetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_widget_config);
        Intent itln =getIntent();
        Bundle extras = itln.getExtras();
        if(extras!=null){
            mAppWidgetId =extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        if(mAppWidgetId ==AppWidgetManager.INVALID_APPWIDGET_ID)
        {
            finish();
        }

        Intent itOut = new Intent("com.android.MY_OWN_WIDGET_UPDATA");
        PendingIntent penIt = PendingIntent.getBroadcast(this,0,itOut,0);
        AlarmManager alaemMan =(AlarmManager)getSystemService(ALARM_SERVICE);
        Calendar calendar =Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND,5);
        alaemMan.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),20*1000,penIt);

        MyAppWidget.SaveAlarmManger(alaemMan,penIt);

        Intent itAppWidgetConfigResult =new Intent();
        itAppWidgetConfigResult.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK,itAppWidgetConfigResult);
        finish();
    }
}
