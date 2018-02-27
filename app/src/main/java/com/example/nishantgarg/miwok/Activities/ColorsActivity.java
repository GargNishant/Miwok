package com.example.nishantgarg.miwok.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.nishantgarg.miwok.Fragments.ColorsFragment;
import com.example.nishantgarg.miwok.R;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.container,new ColorsFragment()).
                commit();

    }
}
