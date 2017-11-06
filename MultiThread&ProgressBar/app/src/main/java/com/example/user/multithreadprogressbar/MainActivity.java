package com.example.user.multithreadprogressbar;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private static class StaticHandler extends Handler {
        private final WeakReference<MainActivity> mActivity;

        public StaticHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }
    }

    public final StaticHandler mHandler = new StaticHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        DoLengthyWork work = new DoLengthyWork();
        work.setHandler(mHandler);
        work.setProgressBar(progressBar);
        work.start();
    }
}
