package com.bluedream.user.character.wepon;

import android.widget.TextView;

/**
 * Created by USER on 2018/1/8.
 */

public class AxeBehavior implements WeponBehavior {
    TextView textView;
    @Override
    public void usewupon(TextView textView) {
        textView.append("使用斧");
    }
}
