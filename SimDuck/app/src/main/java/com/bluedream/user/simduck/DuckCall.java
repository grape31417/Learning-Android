package com.bluedream.user.simduck;

import android.widget.TextView;

import com.bluedream.user.simduck.quackBehavior.MuteQuack;
import com.bluedream.user.simduck.quackBehavior.quackBehavior;

/**
 * Created by USER on 2018/1/8.
 */

public class DuckCall {
    TextView textView;
    quackBehavior quackBehavior;

    public DuckCall(TextView textView) {
        this.textView = textView;
        quackBehavior =new MuteQuack();
    }

    public void setquackBehavior(quackBehavior qb)
    {
        quackBehavior = qb;
    }


    public  void PerformQuack ()
    {
        quackBehavior.quack(textView);
    }


    public void display ()
    {
        textView.append("\n 這是個鴨鳴器 不是鴨子");
    }
}
