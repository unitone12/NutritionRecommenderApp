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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.util.ArrayList;

public class MyDietPlan extends AppCompatActivity {

    TextView myName, myDisease, myGender, myAge, myWeight;
    ImageView img_back, img_home;
    ProgressBar progressBar;

    FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diet_plan);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        myName = findViewById(R.id.name);
        myDisease = findViewById(R.id.disease);
        myGender = findViewById(R.id.gender);
        myAge = findViewById(R.id.age);
        myWeight = findViewById(R.id.max_weight);
        img_back = findViewById(R.id.back_btn);
        img_home = findViewById(R.id.home_btn);


        progressBar = findViewById(R.id.progress_br);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF, android.graphics.PorterDuff.Mode.MULTIPLY);

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

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null){
            databaseReference.child("userdata").child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    ArrayList<String> arrayList = new ArrayList<>();

                    for (DataSnapshot shot : dataSnapshot.getChildren()){
                        arrayList.add(shot.getValue().toString());
                    }
                    myName.setText(arrayList.get(3));
                    myDisease.setText(arrayList.get(1));
                    myAge.setText(arrayList.get(0));
                    myGender.setText(arrayList.get(2));
                    myWeight.setText("Your Height is: "+arrayList.get(4)+" Inches");


                    databaseReference.child("disease").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ArrayList<String> arrayList = new ArrayList<>();

                            for (DataSnapshot shot : dataSnapshot.getChildren()){
                                arrayList.add(shot.getValue().toString());
                            }
                            String disease = myDisease.getText().toString();
                            Toast.makeText(MyDietPlan.this, ""+disease, Toast.LENGTH_SHORT).show();
                            if (disease.equalsIgnoreCase("Calcium Deficiency")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(0));
                            }
                            else if (disease.equalsIgnoreCase("Dehydration")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(1));
                            }
                            else if (disease.equalsIgnoreCase("Diabetes")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(2));
                            }
                            else if (disease.equalsIgnoreCase("Heart Patient")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(3));
                            }
                            else if (disease.equalsIgnoreCase("Iron Deficiency Anemia")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(4));
                            }
                            else if (disease.equalsIgnoreCase("Ketosis")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(5));
                            }
                            else if (disease.equalsIgnoreCase("Pellagra (Niacin)")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(6));
                            }
                            else if (disease.equalsIgnoreCase("Beriberi (Thiamin)")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(7));
                            }
                            else if (disease.equalsIgnoreCase("Xeropthalmic (Vitamin A)")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(8));
                            }
                            else if (disease.equalsIgnoreCase("Scurry (Vitamin C)")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(9));
                            }
                            else if (disease.equalsIgnoreCase("Rickets (Vitamin D)")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(10));
                            }
                            else if (disease.equalsIgnoreCase("VKDB (Vitamin K)")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(11));
                            }
                            else if (disease.equalsIgnoreCase("Physically Weak")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(12));
                            }
                            else if (disease.equalsIgnoreCase("Fat (Heavy Weight)")){
                                new DownloadImageFromInternet((ImageView) findViewById(R.id.dis_plan)).execute(arrayList.get(13));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
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