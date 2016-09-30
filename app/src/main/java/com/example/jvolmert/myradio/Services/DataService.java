package com.example.jvolmert.myradio.Services;


import com.example.jvolmert.myradio.Model.Station;

import java.util.ArrayList;

public class DataService {
    private static DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStations() {
        //  pretend like we just downloaded this from the internet
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan: Tunes for travel", "flightplanmusic"));
        list.add(new Station("2 Wheeling", "bicyclemusic"));
        list.add(new Station("Kids Jamming", "kidsmusic"));

        return list;
    }   //  end of featured music

    public ArrayList<Station> getRecentStations() {
        ArrayList<Station> list = new ArrayList<>();

        return list;


    }

    public ArrayList<Station> getPreviousStations() {
        ArrayList<Station> list = new ArrayList<>();

        return list;

    }

}   //  end of class
