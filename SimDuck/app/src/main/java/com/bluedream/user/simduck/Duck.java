package com.bluedream.user.simduck;

import android.widget.TextView;

import com.bluedream.user.simduck.fjyBehavior.flyBehavior;
import com.bluedream.user.simduck.quackBehavior.quackBehavior;

/**
 * Created by USER on 2018/1/8.
 */

public abstract class Duck {
    flyBehavior flyBehavior;
    quackBehavior quackBehavior;
    TextView textView;

    public Duck(TextView textView) {
        this.textView = textView;
    }

    public abstract void display();

    public void PerformFly() {
        flyBehavior.fly(textView);
    }

    public  void PerformQuack ()
    {
        quackBehavior.quack(textView);
    }

    public void setFlyBehavior (flyBehavior fb)
    {
        flyBehavior=fb;
    }
    public void setQuackBehavior(quackBehavior qb)
    {
        quackBehavior=qb;
    }



}
