package com.bluedream.user.trivalshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SuppressWarnings("Since15")
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    String ResultJson = null;
    JSONObject responseJSON;
    ArrayList<museum> museumclass = new ArrayList<museum>();
    ArrayList<museum> querymuseumclass = new ArrayList<museum>();
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> queryname = new ArrayList<String>();
    Set<String> Setcityname = new HashSet<String>();
    ArrayList<String> ACname = new ArrayList<String>();
    @BindView(R.id.spinner)
    Spinner spinner;
    ArrayAdapter<String>  spinerAdapter;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        OKhttp();
        listviewclick();
        spinerselect();


    }

    private void OKhttp() {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://cloud.culture.tw/frontsite/trans/emapOpenDataAction.do?method=exportEmapJsonByMainType&mainType=10")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "網路下載失敗", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                ResultJson = response.body().string();

                try {
                    JSONArray array = new JSONArray(ResultJson);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        String name = obj.getString("name");
                        String intro = obj.getString("intro");
                        String address = obj.getString("address");
                        String openTime = obj.getString("openTime");
                        String longitude = obj.getString("longitude");
                        String latitude = obj.getString("latitude");
                        String cityname = obj.getString("cityName");
                        museum m = new museum(name, intro, address, openTime, longitude, latitude, cityname);
                        museumclass.add(m);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                update();



            }
        });
    }

    private void update()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < museumclass.size(); i++) {
                    Setcityname.add(museumclass.get(i).getCityName());
                }
                ACname.addAll(Setcityname);

                spinerAdapter = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_spinner_item, ACname);

                spinner.setAdapter(spinerAdapter);

            }
        });

    }

    private void updatequery()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                queryname.clear();
                for (int i = 0; i < querymuseumclass.size(); i++) {
                    queryname.add(querymuseumclass.get(i).getName());
                }
                arrayAdapter = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1, queryname);
                listview.setAdapter(arrayAdapter);
            }
        });

    }

    private void listviewclick() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, intro.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", querymuseumclass.get(position).getName());
                bundle.putString("Intro", querymuseumclass.get(position).getIntro());
                bundle.putString("Address", querymuseumclass.get(position).getAddress());
                bundle.putString("OpenTime", querymuseumclass.get(position).getOpenTime());
                bundle.putString("Latitude", querymuseumclass.get(position).getLatitude());
                bundle.putString("Longitude", querymuseumclass.get(position).getLongitude());
                it.putExtras(bundle);
                startActivity(it);

            }
        });

    }
    protected void spinerselect()
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querymuseumclass.clear();
                String CN =spinerAdapter.getItem(position).toString();
                for(int i=0;i<museumclass.size();i++)
                {
                   if(museumclass.get(i).getCityName().equals(CN))
                   {
                       querymuseumclass.add(museumclass.get(i));
                   }
                }
                updatequery();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}