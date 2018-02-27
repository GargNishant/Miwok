package com.example.nishantgarg.miwok.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nishantgarg.miwok.R;

public class MainActivity extends Activity {
TextView numbersID,phrasesID,familyID,colorsID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbersID=findViewById(R.id.NumbersActivityID);
        phrasesID=findViewById(R.id.PhrasesActivityID);
        colorsID=findViewById(R.id.ColorsActivityID);
        familyID=findViewById(R.id.FamilyActivityID);

        numbersID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(intent);
            }
        });
        phrasesID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(intent);
            }
        });
        colorsID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(intent);
            }
        });
        familyID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(intent);
            }
        });
    }
}
