package com.example.jvolmert.myradio.Model;

// data for app

public class Station {

    private String stationTitle;
    private  String imageUri;
    final String DRAWABLE = "drawable/" ;

    public Station(String stationTitle, String imageUri) {
        this.stationTitle = stationTitle;
        this.imageUri = imageUri;
    }


    public String getStationTitle() {
        return stationTitle;
    }


    public String getImageUri() {
        return imageUri;
    }


}
