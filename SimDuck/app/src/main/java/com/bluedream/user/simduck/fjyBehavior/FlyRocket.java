package com.bluedream.user.simduck.fjyBehavior;

import android.widget.TextView;

/**
 * Created by USER on 2018/1/8.
 */

public class FlyRocket implements flyBehavior {
    @Override
    public void fly(TextView textView) {
        textView.append("\n裝備火箭推進器!");
    }
}
