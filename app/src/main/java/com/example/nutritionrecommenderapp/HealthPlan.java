package com.example.nutritionrecommenderapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;

public class HealthPlan extends AppCompatActivity {

    TextView textView;
    Spinner spinner;
    ImageView imageView, img_back, img_home;
    String[] data_img = {"", "diabetes", "heart", "dehydration", "iron", "calcium", "ketosis", "vitamina", "vitamind", "thiamin", "niacin",
                    "vitaminc", "vitamink", "weightgain", "weightloss"};
    ProgressBar progressBar;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("disease");
    private DatabaseReference Reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_plan);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView = findViewById(R.id.txt);
        spinner = findViewById(R.id.dis_spin);
        imageView = findViewById(R.id.img_vw);
        img_back = findViewById(R.id.back_btn);
        img_home = findViewById(R.id.home_btn);

        progressBar = findViewById(R.id.progress_br);
        progressBar.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF, android.graphics.PorterDuff.Mode.MULTIPLY);


        final String [] Disease = {"Select Disease", "Diabetes", "Heart Patient", "Dehydration", "Iron Deficiency Anemia", "Calcium Deficiency",
                                   "Ketosis", "Xerophthalmic (Vitamin A)", "Rickets (Vitamin D)", "Beriberi (Thiamin)", "Pellagra (Niacin)",
                                   "Scurry (Vitamin C)", "VKDB (Vitamin K)", "Physically Weak", "Fat (Heavy Weight)"};

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

        ArrayAdapter<String> diseaseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Disease);
        spinner.setAdapter(diseaseAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position != 0) {
                    progressBar.setVisibility(View.VISIBLE);
                    Reference = databaseReference.child(data_img[position]);
                    Reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String message = dataSnapshot.getValue(String.class);
                            textView.setText(message);
                            new DownloadImageFromInternet((ImageView) findViewById(R.id.img_vw))
                                    .execute(message);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
            progressBar.setVisibility(View.GONE);
        }
    }
}