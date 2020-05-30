package com.example.nutritionrecommenderapp;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ArticleView extends AppCompatActivity {

    ListView list_article_view;
    int position;
    ImageView img_back, img_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_view);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        list_article_view = findViewById(R.id.list_view_article_views);
        img_back = findViewById(R.id.back_btn);
        img_home = findViewById(R.id.home_btn);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Article.class);
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

        final String [] diff_ages = {"2 to 3 Year old Child", "4 to 8 Year old Boys", "4 to 8 Year old Girls", "9 to 13 Year old Boys",
                                     "9 to 13 Year old Grils", "14 to 18 Year old Boys", "14 to 18 Year old Girls", "Old age People"};

        final String [] fruits = {"Apple", "Apricot", "Banana", "Cherry", "Coconut", "Date", "Grapes", "Mango", "Orange", "Pear", "Watermelon"};

        final String [] dryfruits = {"Almond", "Cantaloupe Seed", "Cashew Nut", "Chest Nut", "Peanut", "Pine Nut", "Pistachio", "Walnut"};

        final String [] vegetables = {"Bellpepper", "Bitter Gourd", "Brinjal", "Cabbage", "Carrot", "Corinder", "Cucumber", "Garlic", "Ginger",
                                      "Lady Finger", "Onion", "Potato", "Pumpkin", "Tomato"};

        final String [] meat = {"Beaf", "Camel", "Chicken", "Fish", "Mutton", "Prawn"};

        final String [] beans = {"Black Bean", "Black Eyed Bean", "Chickpea", "Corn", "French Bean", "Kidney Bean", "Lentils", "Mung Bean", "Pea",
                                 "Pinto Bean", "Soybean"};

        final String [] beverages = {"Coconut Milk", "Coffee", "Iced Tea", "Juice", "Lemonade", "Milk","Tea"};

        final String [] breakfast = {"Berries", "Chia Seed", "Egg", "Oatmeal", "Shake", "Yogurt"};

        final String [] lunch = {"Lunch One", "Lunch Two", "Lunch Three", "Lunch Four", "Lunch Five", "Lunch Six", "Lunch Seven"};

        final String [] dinner = {"Dinner One", "Dinner Two", "Dinner Three", "Dinner Four", "Dinner Five", "Dinner Six",};


        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt("position");

        if (position == 0){
            setTitle("Food Choices");
            ArrayAdapter<String> diffAgeAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, diff_ages);
            list_article_view.setAdapter(diffAgeAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }

        else if (position == 1) {
            setTitle("Fruits");
            ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, fruits);
            list_article_view.setAdapter(fruitAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }

        else if (position == 2){
            setTitle("Dry Fruits");
            ArrayAdapter<String> dryfruitAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, dryfruits);
            list_article_view.setAdapter(dryfruitAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }
        else if (position == 3){
            setTitle("Vegetables");
            ArrayAdapter<String> vegeAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, vegetables);
            list_article_view.setAdapter(vegeAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }
        else if (position == 4){
            setTitle("Meat");
            ArrayAdapter<String> meatAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, meat);
            list_article_view.setAdapter(meatAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }
        else if (position == 5){
            setTitle("Beans");
            ArrayAdapter<String> beansAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, beans);
            list_article_view.setAdapter(beansAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }
        else if (position == 6){
            setTitle("Beverages");
            ArrayAdapter<String> beverageAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, beverages);
            list_article_view.setAdapter(beverageAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }
        else if (position == 7){
            setTitle("Tips for Breakfast");
            ArrayAdapter<String> breakfastAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, breakfast);
            list_article_view.setAdapter(breakfastAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }
        else if (position == 8){
            setTitle("Tips for Lunch");
            ArrayAdapter<String> lunchAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, lunch);
            list_article_view.setAdapter(lunchAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }
        else if (position == 9){
            setTitle("Tips for Dinner");
            ArrayAdapter<String> dinnerAdapter = new ArrayAdapter<String>(this, R.layout.list_design, R.id.list_txt, dinner);
            list_article_view.setAdapter(dinnerAdapter);
            list_article_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int key, long id) {
                    Intent intent = new Intent(ArticleView.this, ArticleImage.class);
                    intent.putExtra("position", position);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }
            });
        }

    }
}
