package com.bluedream.user.simduck.fjyBehavior;

import android.widget.TextView;

/**
 * Created by USER on 2018/1/8.
 */

public class FlyNoWay implements flyBehavior {

    @Override
    public void fly(TextView textView) {
        TextView test =textView;
        test.append("\nI Can Not Fly");
    }
}
