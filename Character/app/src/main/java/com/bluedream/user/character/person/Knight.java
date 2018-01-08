package com.bluedream.user.character.person;

import android.widget.TextView;

/**
 * Created by USER on 2018/1/8.
 */

public class Knight extends Character {
    public Knight(TextView textView) {
        super(textView);
    }

    public void display()
    {
        textView.append("\n騎士");
    }
}
