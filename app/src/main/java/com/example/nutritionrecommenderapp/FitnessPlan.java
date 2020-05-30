package com.example.nutritionrecommenderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FitnessPlan extends AppCompatActivity {

    ListView listView;
    ImageView img_back, img_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_plan);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listView = findViewById(R.id.fitness_view);
        img_back = findViewById(R.id.back_btn);
        img_home = findViewById(R.id.home_btn);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        String [] fitnessDiet = {"Body Building Diet", "Science Based Body Building Diet", "Diet for Abs", "30 Day BeachBody Diet",
                                 "80 Day Obsession Diet", "Diet for Biceps", "Military Diet Plan", "Muscle Diet Plan"};

        ArrayAdapter<String> dietAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, fitnessDiet);
        listView.setAdapter(dietAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FitnessPlan.this, FitnessView.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}