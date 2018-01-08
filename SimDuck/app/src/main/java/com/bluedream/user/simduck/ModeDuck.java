package com.bluedream.user.simduck;

import android.widget.TextView;

import com.bluedream.user.simduck.fjyBehavior.FlyNoWay;
import com.bluedream.user.simduck.quackBehavior.Quack;

/**
 * Created by USER on 2018/1/8.
 */

public class ModeDuck extends Duck {
    public ModeDuck(TextView textView) {
        super(textView);
      flyBehavior =new FlyNoWay();
      quackBehavior =new Quack();

    }

    @Override
    public void display() {
        textView.append("\n模型鴨子");

    }
}
