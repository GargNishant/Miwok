package com.example.nishantgarg.miwok.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.nishantgarg.miwok.Helper.FragmentHelper;
import com.example.nishantgarg.miwok.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        FragmentHelper helper =new FragmentHelper(getSupportFragmentManager());
        viewPager.setAdapter(helper);
    }
}
