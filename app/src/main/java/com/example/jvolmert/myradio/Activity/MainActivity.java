package com.example.jvolmert.myradio.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jvolmert.myradio.Fragments.MainFragment;
import com.example.jvolmert.myradio.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Need to declare the Fragment manager to include in our main java file
        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance("blah", "kah");

            //begin using the fragment
            fm.beginTransaction()
                    .add(R.id.container_main, mainFragment)
                    .commit();
        }

    }


}
