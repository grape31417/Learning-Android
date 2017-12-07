package com.example.user.googlemap;

import android.content.Context;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.user.googlemap.MapsActivity.mLocation;
import static com.example.user.googlemap.MapsActivity.mMap;
import static com.example.user.googlemap.MapsActivity.mMarker1;
import static com.example.user.googlemap.MapsActivity.mMarker2;
import static com.example.user.googlemap.MapsActivity.mMarker3;
import static com.example.user.googlemap.MapsActivity.mMarker4;
import static com.example.user.googlemap.MapsActivity.mPolylineRoute;

/**
 * Created by USER on 2017/12/6.
 */

public class Button extends android.widget.Button implements View.OnClickListener {
    String mode;
    public Button(Context context,String mode) {
        super(context);
        this.mode=mode;
    }

    @Override
    public void onClick(View v) {
      switch (mode) {
          case "3dmap":
          // 設定地圖的俯視角度，並且放大到一定的等級，讓3D建築物出現。
          CameraUpdate camUpdate = CameraUpdateFactory.newCameraPosition(
                  new CameraPosition.Builder()
                          .target(mMap.getCameraPosition().target)
                          .tilt(60)
                          .zoom(18)
                          .build());
          mMap.animateCamera(camUpdate);
          case "btnAddMarkerOnClick":
              if (mMarker1 == null) {
                  String[] sLocation = mLocation[0][1].split(",");
                  double dLat = Double.parseDouble(sLocation[0]);
                  double dLon = Double.parseDouble(sLocation[1]);
                  mMarker1 = mMap.addMarker(new MarkerOptions()
                          .title(mLocation[0][0])
                          .snippet("2004年完工,高509公尺")
                          .position(new LatLng(dLat, dLon))
                          .icon(BitmapDescriptorFactory.fromResource(R.drawable.arrows))
                          .anchor(0.5f, 0.5f));
              }

              if (mMarker2 == null) {
                  String[] sLocation = mLocation[1][1].split(",");
                  double dLat = Double.parseDouble(sLocation[0]);
                  double dLon = Double.parseDouble(sLocation[1]);
                  mMarker2 = mMap.addMarker(new MarkerOptions()
                          .title(mLocation[1][0])
                          .snippet("東起山海關,西至嘉峪關,全長6000多公里")
                          .position(new LatLng(dLat, dLon))
                          .icon(BitmapDescriptorFactory.fromResource(R.drawable.circle))
                          .anchor(0.5f, 0.5f));
              }

              if (mMarker3 == null) {
                  String[] sLocation = mLocation[2][1].split(",");
                  double dLat = Double.parseDouble(sLocation[0]);
                  double dLon = Double.parseDouble(sLocation[1]);
                  mMarker3 = mMap.addMarker(new MarkerOptions()
                          .title(mLocation[2][0])
                          .snippet("1886年完工,高93公尺")
                          .position(new LatLng(dLat, dLon))
                          .icon(BitmapDescriptorFactory.fromResource(R.drawable.square))
                          .anchor(0.5f, 0.5f));
              }

              if (mMarker4 == null) {
                  String[] sLocation = mLocation[3][1].split(",");
                  double dLat = Double.parseDouble(sLocation[0]);
                  double dLon = Double.parseDouble(sLocation[1]);
                  mMarker4 = mMap.addMarker(new MarkerOptions()
                          .title(mLocation[3][0])
                          .snippet("又稱為艾菲爾鐵塔,高324公尺")
                          .position(new LatLng(dLat, dLon))
                          .icon(BitmapDescriptorFactory.fromResource(R.drawable.star))
                          .anchor(0.5f, 0.5f));
              }
              break;
          case "btnRemoveMarkerOnClick":
              if (mMarker1 != null) {
                  mMarker1.remove();
                  mMarker1 = null;
              }
              if (mMarker2 != null) {
                  mMarker2.remove();
                  mMarker2 = null;
              }
              if (mMarker3 != null) {
                  mMarker3.remove();
                  mMarker3 = null;
              }
              if (mMarker4 != null) {
                  mMarker4.remove();
                  mMarker4 = null;
              }
              break;

          case "btnShowRouteOnClick":
              mPolylineRoute.setVisible(true);

              break;

          case "btnHideRouteOnClick":
              mPolylineRoute.setVisible(false);
              break;

      }
    };


}
