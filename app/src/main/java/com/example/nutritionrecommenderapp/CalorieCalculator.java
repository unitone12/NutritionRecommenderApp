package com.example.nutritionrecommenderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalorieCalculator extends AppCompatActivity {

    EditText edit_age, edit_weight, edit_height;
    Spinner spinner;
    Button button;
    TextView textView;
    int point;
    ImageView img_back, img_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edit_age = findViewById(R.id.edt_age);
        edit_weight = findViewById(R.id.edt_wgt);
        edit_height = findViewById(R.id.edt_hgt);
        spinner = findViewById(R.id.cal_spin);
        button = findViewById(R.id.res_btn);
        textView = findViewById(R.id.result);
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

        String [] gender = {"Select Gender", "Male", "Female"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, gender);
        spinner.setAdapter(genderAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==1){
                    point = position;
                }
                else if (position==2){
                    point = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double age, weight, height, bmr;

                if (edit_age.getText().toString().isEmpty()) {
                    edit_age.setError("Field is Empty");
                }
                else if (edit_weight.getText().toString().isEmpty()) {
                    edit_weight.setError("Field is Empty");
                }
                else if (edit_height.getText().toString().isEmpty()) {
                    edit_height.setError("Field is Empty");
                }
                else {
                    age = Double.parseDouble(edit_age.getText().toString());
                    weight = Double.parseDouble(edit_weight.getText().toString());
                    height = Double.parseDouble(edit_height.getText().toString());
                    if (point == 2) {

                        bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
                        textView.setText(String.valueOf(bmr)+" calories/day to Maintain that Stat");
                    }
                    else if (point == 1){

                        bmr = (10 * weight) + (6.25 * height) - (5 * age) - 5;
                        textView.setText(String.valueOf(bmr)+" calories/day  to Maintain that Stat");
                    }
                    else if (point == 0){
                        Toast.makeText(getApplicationContext(), "Select Gender", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

    }
}
