package com.example.admin.tour_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button schools,restaurant,malls,churches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        schools=(Button)findViewById(R.id.schoolBtn);
        schools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boitu = new Intent(MainActivity.this, Schools.class);
                startActivity(boitu);
            }
        });

        restaurant=(Button)findViewById(R.id.restaurantBtn);
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boitu = new Intent(MainActivity.this, Restaurants.class);
                startActivity(boitu);
            }
        });

        malls=(Button)findViewById(R.id.mallsBtn);
        malls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boitu = new Intent(MainActivity.this, Malls.class);
                startActivity(boitu);
            }
        });

        churches=(Button)findViewById(R.id.churchesBtn);
        churches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boitu = new Intent(MainActivity.this, Churches.class);
                startActivity(boitu);
            }
        });


    }
}
