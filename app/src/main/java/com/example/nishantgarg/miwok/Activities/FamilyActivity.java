package com.example.nishantgarg.miwok.Activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.nishantgarg.miwok.Fragments.FamilyFragment;
import com.example.nishantgarg.miwok.R;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.container,new FamilyFragment()).
                commit();

    }
}
