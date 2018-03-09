package com.example.nishantgarg.miwok.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.nishantgarg.miwok.Helper.FragmentHelper;
import com.example.nishantgarg.miwok.R;

public class MainActivity extends AppCompatActivity {

    private static final  String[] fragmentName = {"Numbers",
    "Family","Color","Phrases"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        FragmentHelper helper =new FragmentHelper(getSupportFragmentManager());
        viewPager.setAdapter(helper);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


        for(int i=0; i<4; i++){
            tabLayout.getTabAt(i).setText(fragmentName[i]);
        }
    }
}
