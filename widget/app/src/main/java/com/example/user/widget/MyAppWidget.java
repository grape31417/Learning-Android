package com.example.user.widget;

/**
 * Created by USER on 2017/11/10.
 */

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by USER on 2017/11/10.
 */

public class MyAppWidget extends AppWidgetProvider{
    private static final String LOG_TAG= "MyAppWidget";
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(LOG_TAG,"onReceive()");
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
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(LOG_TAG,"onEnabled()");
    }
}
