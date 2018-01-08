package com.bluedream.user.simduck.quackBehavior;

import android.widget.TextView;

/**
 * Created by USER on 2018/1/8.
 */

public class Squack implements quackBehavior{

        @Override
        public void quack(TextView textView) {
            TextView test =textView;
            test.append("\n Suack!");

    }
}
