package com.bluedream.user.githubapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView AAA;
    String SSS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AAA=(TextView) findViewById(R.id.ssss);
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://2016.cec.gov.tw/opendata/api/proofreadercanrpt/json")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                SSS=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AAA.setText(SSS);
                    }
                });

            }
        });
    }
}
