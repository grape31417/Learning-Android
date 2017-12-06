package com.example.user.googlemap;

import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by USER on 2017/12/6.
 */

public class adapterOnITEMClick extends AdapterView implements AdapterView.OnItemSelectedListener{
    public adapterOnITEMClick(Context context) {
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
        switch (position) {
            case 0:
                MapsActivity.mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case 1:
                MapsActivity.mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case 2:
                MapsActivity.mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case 3:
                MapsActivity.mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
