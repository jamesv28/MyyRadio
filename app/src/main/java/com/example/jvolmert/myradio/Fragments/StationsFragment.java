package com.example.jvolmert.myradio.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.example.jvolmert.myradio.R;
import com.example.jvolmert.myradio.Services.DataService;
import com.example.jvolmert.myradio.adapters.StationsAdater;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StationsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {

    private static final String ARG_STATION_TYPE = "station_type";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PREV = 2;
    private int stationType;

    private OnFragmentInteractionListener mListener;

    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType Parameter 1.
     */

    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt("", stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stations, container, false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_stations);
        recyclerView.setHasFixedSize(true);


        StationsAdater adapter;

        if (stationType == STATION_TYPE_FEATURED) {

            adapter = new StationsAdater(DataService.getInstance().getFeaturedStations());
        } else if (stationType == STATION_TYPE_RECENT) {

            adapter = new StationsAdater(DataService.getInstance().getRecentStations());
        } else {
            adapter = new StationsAdater(DataService.getInstance().getPreviousStations());

        }

        recyclerView.setAdapter(adapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
