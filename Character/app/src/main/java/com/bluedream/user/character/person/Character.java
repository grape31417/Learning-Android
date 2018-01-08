package com.bluedream.user.character.person;

import android.widget.TextView;

import com.bluedream.user.character.wepon.WeponBehavior;

/**
 * Created by USER on 2018/1/8.
 */

public abstract class Character {
    TextView textView;
    WeponBehavior weponBehavior;

    public  abstract void  display();

    public Character(TextView textView) {
        this.textView = textView;
    }
    public void fight()
    {
        textView.append("攻擊!");
    }

    public void usewepon()
    {
        weponBehavior.usewupon(textView);
    }

    public void setWeponBehavior (WeponBehavior wb)
    {
        this.weponBehavior=wb;
    }
}
