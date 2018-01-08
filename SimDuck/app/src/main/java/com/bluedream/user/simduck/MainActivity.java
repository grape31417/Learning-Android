package com.bluedream.user.simduck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bluedream.user.simduck.fjyBehavior.FlyRocket;
import com.bluedream.user.simduck.quackBehavior.Squack;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.textview);

       Duck Mallard =new MallardDuck(text);
       Mallard.display();
       Mallard.PerformFly();
       Mallard.PerformQuack();

       Duck ModelWithRocket =new ModeDuck(text);
       ModelWithRocket.display();
        ModelWithRocket.setFlyBehavior(new FlyRocket());
        ModelWithRocket.PerformFly();

        DuckCall DuckCall =new DuckCall(text);
        DuckCall.display();
        DuckCall.setquackBehavior(new Squack()) ;
        DuckCall.PerformQuack();


    }
}
