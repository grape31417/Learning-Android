package com.bluedream.user.simduck;

import android.widget.TextView;

import com.bluedream.user.simduck.fjyBehavior.FlyWithWing;
import com.bluedream.user.simduck.quackBehavior.Quack;

/**
 * Created by USER on 2018/1/8.
 */

public class MallardDuck extends Duck {

    public MallardDuck(TextView textView) {
        super(textView);
        quackBehavior =new Quack();
        flyBehavior= new FlyWithWing();
    }

    @Override
    public void display() {
        textView.append("\n綠色鴨子");
    }


}
