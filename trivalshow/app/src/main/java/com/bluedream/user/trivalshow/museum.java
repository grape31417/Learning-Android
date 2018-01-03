package com.bluedream.user.trivalshow;

/**
 * Created by USER on 2018/1/3.
 */

public class museum {
    String name;
    String intro;
    String address;
    String openTime;
    String longitude;
    String latitude;
    String cityName;


    public museum(String name, String intro, String address, String openTime, String longitude, String latitude, String cityName) {
        this.name = name;
        this.intro = intro;
        this.address = address;
        this.openTime = openTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.cityName = cityName;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
