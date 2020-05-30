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

public class Article extends AppCompatActivity {

    ListView listView_article;
    ImageView img_back, img_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listView_article = findViewById(R.id.list_view_article);
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

        String[] article = {"Diet Plan for Diff. Ages", "Nutrients Imp. of Fruits", "Nutrients Imp. of Dry Fruits", "Nutrients Imp. of Vegetables",
                "Nutrients Imp. of Meat", "Nutrients Imp. of Beans", "Nutrients Imp. of Beverages", "Tips for Healthy Breakfast",
                "Tips for Healthy Lunch", "Tips for Healty Dinner"};


        ArrayAdapter<String> articleAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, article);
        listView_article.setAdapter(articleAdapter);
        listView_article.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Article.this, ArticleView.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }
}