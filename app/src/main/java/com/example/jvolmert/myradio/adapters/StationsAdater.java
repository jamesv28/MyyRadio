package com.example.jvolmert.myradio.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jvolmert.myradio.Holders.StationViewHolder;
import com.example.jvolmert.myradio.Model.Station;

import java.util.ArrayList;

public class StationsAdater extends RecyclerView.Adapter<StationViewHolder>{

    private ArrayList<Station> stations;

    public StationsAdater(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
}
