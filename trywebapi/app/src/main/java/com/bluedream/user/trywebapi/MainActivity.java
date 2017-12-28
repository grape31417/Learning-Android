package com.bluedream.user.trywebapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    TextView AAA;
    EditText name, job;
    Button go;
    String CCC;
    String str;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final String POST = "POST";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AAA = (TextView) findViewById(R.id.aaaa);
        name = (EditText) findViewById(R.id.name);
        job = (EditText) findViewById(R.id.job);
        go = (Button) findViewById(R.id.apibutton);
        go.setOnClickListener(goO);



    }

    private View.OnClickListener goO =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OkHttpClient client = new OkHttpClient();

            JSONObject json = new JSONObject();
            try {
                json.put("title", job.getText().toString());
                json.put("name",name.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            RequestBody requestBody = RequestBody.create(JSON, json.toString());

            FormBody.Builder params = new FormBody.Builder();
            params.add("title", "Mr");
            params.add("name", "gnehcic");
            FormBody formBody = params.build();

            final Request request = new Request.Builder()
                    .url("http://gnehcic.azurewebsites.net/sample/SampleWebAPI.php")
                    .post(requestBody)
                    .build();
            Call call = client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    CCC = null;
                    CCC= response.body().string();
                    try {
                        JSONObject responseJSON = new JSONObject(CCC);
                        str=responseJSON.getString("message");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AAA.setText(str);
                        }
                    });

                }

            });

        }
    };


}



