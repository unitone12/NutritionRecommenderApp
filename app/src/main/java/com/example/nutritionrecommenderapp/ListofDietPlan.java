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
import android.widget.Toast;

public class ListofDietPlan extends AppCompatActivity {

    ListView listView;
    TextView textView;
    ImageView img_back, img_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_diet_plan);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.list_txt);
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







        String [] typeoflist = {"Ketogenic Diet", "Vegetarian Diet", "Vegan Diet", "Weight Watchers Diet", "Atkins Diet", "The Zone Diet",
                                "Raw Food Diet", "Mediterranean Diet"};


        ArrayAdapter<String> dietAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, typeoflist);
        listView.setAdapter(dietAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListofDietPlan.this, DietPlan.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}