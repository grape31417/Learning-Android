package com.example.user.googlemap;

import android.content.Context;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;

import static com.example.user.googlemap.MapsActivity.mMap;

/**
 * Created by USER on 2017/12/6.
 */

public class Button extends android.widget.Button implements View.OnClickListener {
    public Button(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        if (v==MapsActivity.mbtn3dMap)
        {
            // 設定地圖的俯視角度，並且放大到一定的等級，讓3D建築物出現。
            CameraUpdate camUpdate = CameraUpdateFactory.newCameraPosition(
                    new CameraPosition.Builder()
                            .target(mMap.getCameraPosition().target)
                            .tilt(60)
                            .zoom(18)
                            .build());
            mMap.animateCamera(camUpdate);
        }

    }
}
