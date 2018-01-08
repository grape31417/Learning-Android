package com.bluedream.user.character.person;

import android.widget.TextView;

/**
 * Created by USER on 2018/1/8.
 */

public class Troll extends Character {
    public Troll(TextView textView) {
        super(textView);
    }

    public void display()
    {
        textView.append("\n巨人");
    }
}
