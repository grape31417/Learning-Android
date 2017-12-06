package com.example.user.googlemap;

import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by USER on 2017/12/6.
 */

public class AdapterOnitemSelect extends AdapterView implements AdapterView.OnItemSelectedListener {
    public AdapterOnitemSelect(Context context) {
        super(context);
    }

    @Override
    public Adapter getAdapter() {
        return null;
    }

    @Override
    public void setAdapter(Adapter adapter) {

    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setSelection(int position) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        int iSelected = MapsActivity.mSpnLocation.getSelectedItemPosition();
        String[] sLocation = MapsActivity.mLocation[iSelected][1].split(",");
        double dLat = Double.parseDouble(sLocation[0]);	// 南北緯
        double dLon = Double.parseDouble(sLocation[1]);	// 東西經
        MapsActivity.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(dLat, dLon), 14));


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
