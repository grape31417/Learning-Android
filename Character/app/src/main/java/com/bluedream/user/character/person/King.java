package com.bluedream.user.character.person;

import android.widget.TextView;

/**
 * Created by USER on 2018/1/8.
 */

public class King extends Character {
    public King(TextView textView) {
        super(textView);
    }

    public void display()
    {
        textView.append("\n國王");
    }
}
