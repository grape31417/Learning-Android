package com.example.user.widget;

/**
 * Created by USER on 2017/11/10.
 */

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by USER on 2017/11/10.
 */

public class MyAppWidget extends AppWidgetProvider{
    private static final String LOG_TAG= "MyAppWidget";
    private static AlarmManager malarmManager;
    private static PendingIntent mPendingIntent;

    static void SaveAlarmManger (AlarmManager alarmManager,PendingIntent pendingIntent)
    {
        malarmManager =alarmManager;
        mPendingIntent =pendingIntent;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if(!intent.getAction().equals("com.android.MY_OWN_WIDGET_UPDATA"))
            return;
        Log.d(LOG_TAG,"onReceive()");
        AppWidgetManager appwidgetman =AppWidgetManager.getInstance(context);
        ComponentName thisAppWidget =new ComponentName(context.getPackageName(),MyAppWidget.class.getName());
        int[] appWidgetIds = appwidgetman.getAppWidgetIds(thisAppWidget);
        onUpdate(context,appwidgetman,appWidgetIds);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.d(LOG_TAG,"onUpdate()");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.d(LOG_TAG,"onDeleted()");
        malarmManager.cancel(mPendingIntent);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(LOG_TAG,"onEnabled()");
    }
}
