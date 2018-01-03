package com.bluedream.user.trivalshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class intro extends AppCompatActivity {
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.address)
    TextView Address;
    @BindView(R.id.opentime)
    TextView opentime;
    @BindView(R.id.intro)
    TextView Intro;
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.Mapbutton)
    Button Mapbutton;
    private GoogleMap map;
    String name;
    String intro;
    String address;
    String openTime;
    Double longitude;
    Double latitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
        getbundle();
        setText();

    }


    private void getbundle() {
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        intro = bundle.getString("Intro");
        address = bundle.getString("Address");
        openTime = bundle.getString("OpenTime");
        longitude = Double.valueOf(bundle.getString("Longitude"));
        latitude = Double.valueOf(bundle.getString("Latitude"));

    }

    private void setText() {
        titleName.setText(name);
        Address.append(address);
        opentime.append("\n"+openTime);
        Intro.append("\n"+intro);

    }


    @OnClick(R.id.back)
    public void onbackViewClicked() {
        finish();
    }

    @OnClick(R.id.Mapbutton)
    public void MapbuttononViewClicked() {
        Intent it=new Intent();
        it.setClass(intro.this,MapsActivity.class);
        Bundle bundle=new Bundle();
        bundle.putDouble("longitude",longitude);
        bundle.putDouble("latitude",latitude);
        bundle.putString("name",name);
        it.putExtras(bundle);
        startActivity(it);
    }
}
