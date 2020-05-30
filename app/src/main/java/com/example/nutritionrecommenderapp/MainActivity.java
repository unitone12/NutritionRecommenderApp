package com.example.nutritionrecommenderapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button myplan, disease, diet, fitness, calorie, article;
    ImageView log_img;
    ListView listView;
    ArrayAdapter<String> adapter;
    int count=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        myplan = findViewById(R.id.my_plan);
        disease = findViewById(R.id.health);
        diet = findViewById(R.id.list);
        fitness = findViewById(R.id.fintess);
        calorie = findViewById(R.id.calorie);
        article = findViewById(R.id.article);
        log_img = findViewById(R.id.logout);
        listView = findViewById(R.id.list_search);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.my_list)));
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String itemText = (String) (listView.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(),itemText,Toast.LENGTH_LONG).show();
                if (itemText.equalsIgnoreCase("Diet Plan According to health")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("My Diet Plan")){
                    Intent intent = new Intent(MainActivity.this, MyDietPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Diabetes")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Heart Patient")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Dehydration")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Iron Deficiency Anemia")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Calcium Deficiency")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Ketosis")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Xerophthalmic (Vitamin A)")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Rickets (Vitamin D)")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Beriberi (Thiamin)")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Pellagra (Niacin)")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Scurry (Vitamin C)")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("VKDB (Vitmain K)")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Weight Gain")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Weight Loss")){
                    Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                    startActivity(intent);
                }

                else if (itemText.equalsIgnoreCase("List of Diet Plan")){
                    Intent intent = new Intent(MainActivity.this, ListofDietPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Ketogenic Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 0);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Vegetarian Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 1);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Vegan Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 2);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Weight Watchers Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 3);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Atkins Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 4);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("The Zone Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 5);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Raw Food Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 6);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Mediterranean Diet")){
                    Intent intent = new Intent(MainActivity.this, DietPlan.class);
                    intent.putExtra("position", 7);
                    startActivity(intent);
                }

                else if (itemText.equalsIgnoreCase("Fitness Plan")){
                    Intent intent = new Intent(MainActivity.this, FitnessPlan.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Body Building Diet")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 0);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Science Based Body Building Diet")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 1);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Diet for Abs")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 2);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("30 Day BeachBody Diet")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 3);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("80 Day Obsession Diet")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 4);
                    startActivity(intent);
                }else if (itemText.equalsIgnoreCase("Diet for Biceps")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 5);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Military Diet Plan")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 6);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Muscle Diet")){
                    Intent intent = new Intent(MainActivity.this, FitnessView.class);
                    intent.putExtra("position", 7);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Calorie Calculator")) {
                    Intent intent = new Intent(MainActivity.this, CalorieCalculator.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Article")){
                    Intent intent = new Intent(MainActivity.this, Article.class);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Food Choices")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 0);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Fruits")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 1);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Dry Fruits")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 2);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Vegetables")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 3);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Meat")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 4);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Beans")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 5);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Beverages")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 6);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Tips for Breakfast")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 7);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Tips for Lunch")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 8);
                    startActivity(intent);
                }
                else if (itemText.equalsIgnoreCase("Tips for Dinner")){
                    Intent intent = new Intent(MainActivity.this, ArticleView.class);
                    intent.putExtra("position", 9);
                    startActivity(intent);
                }
            }
        });

        myplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyDietPlan.class);
                startActivity(intent);
            }
        });

        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthPlan.class);
                startActivity(intent);
            }
        });

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListofDietPlan.class);
                startActivity(intent);
            }
        });

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FitnessPlan.class);
                startActivity(intent);
            }
        });

        calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalorieCalculator.class);
                startActivity(intent);
            }
        });

        article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Article.class);
                startActivity(intent);
            }
        });

        log_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                SharedPreferences sharedPreferences = getSharedPreferences("logout", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("ok", 1);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_app);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                listView.setVisibility(View.GONE);
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                listView.setVisibility(View.VISIBLE);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {

        if (count < 1){
            Toast.makeText(this, "Press Again to Close the App", Toast.LENGTH_SHORT).show();
        }
        else {
            finishAffinity();
        }
        count++;
    }
}