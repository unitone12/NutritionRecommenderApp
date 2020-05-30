package com.example.nutritionrecommenderapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;

public class ArticleImage extends AppCompatActivity {

    TextView txt_art;
    ImageView imageView;
    int article_point;
    ProgressBar progressBar;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    private DatabaseReference Reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_image);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txt_art = findViewById(R.id.url_article);
        imageView = findViewById(R.id.img_article);
        progressBar = findViewById(R.id.progress_ar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF, android.graphics.PorterDuff.Mode.MULTIPLY);


        String[] ageslist = {"2to3both", "4to8boys", "4to8girls", "9to13boys", "9to13girls", "14to18boys", "14to18girls", "oldage"};

        String[] fruitlist = {"apple", "apricot", "banana", "cherry", "coconut", "date", "grape", "mango", "orange", "pear", "watermelon"};

        String[] dryfruitlist = {"almond", "cantaloupe", "cashew", "chest", "peanut", "pine", "pistachio", "walnut"};

        String[] vegetablelist = {"bellpepper", "gourd", "brinjal", "cabbage", "carrot", "corinder", "cucumber", "garlic", "ginger", "ladyfinger",
                "onion", "potato", "pumpkin", "tomato"};

        String[] meatlist = {"beaf", "camel", "chicken", "fish", "mutton", "prawn"};

        String[] beanlist = {"blackbean", "blackeyed", "chickpea", "corn", "frenchbean", "kidneybean", "lentil", "mungbean", "pea", "pintobean",
                "soybean"};

        String[] beveragelist = {"coconutmilk", "coffee", "icetea", "juice", "lemonade", "milk", "tea"};

        String[] breakfastlist = {"berries", "chiaseed", "egg", "oatmeal", "shake", "yogurt"};

        String[] lunchlist = {"tipone", "tiptwo", "tipthree", "tipfour", "tipfive", "tipsix", "tipseven"};

        String[] dinnerlist = {"dinnerone", "dinnertwo", "dinnerthree", "dinnerfour", "dinnerfive", "dinnersix"};

        Bundle bundle = getIntent().getExtras();
        article_point = bundle.getInt("position");
        int key = bundle.getInt("key");

        if (article_point == 0) {
            databaseReference = firebaseDatabase.getReference("diffages");
            Reference = databaseReference.child(ageslist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 1) {
            databaseReference = firebaseDatabase.getReference("fruit");
            Reference = databaseReference.child(fruitlist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 2) {
            databaseReference = firebaseDatabase.getReference("dryfruit");
            Reference = databaseReference.child(dryfruitlist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 3) {
            databaseReference = firebaseDatabase.getReference("vegetable");
            Reference = databaseReference.child(vegetablelist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 4) {
            databaseReference = firebaseDatabase.getReference("meat");
            Reference = databaseReference.child(meatlist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 5) {
            databaseReference = firebaseDatabase.getReference("bean");
            Reference = databaseReference.child(beanlist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 6) {
            databaseReference = firebaseDatabase.getReference("beverage");
            Reference = databaseReference.child(beveragelist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 7) {
            databaseReference = firebaseDatabase.getReference("breakfast");
            Reference = databaseReference.child(breakfastlist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 8) {
            databaseReference = firebaseDatabase.getReference("lunch");
            Reference = databaseReference.child(lunchlist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (article_point == 9) {
            databaseReference = firebaseDatabase.getReference("dinner");
            Reference = databaseReference.child(dinnerlist[key]);
            Reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String message = dataSnapshot.getValue(String.class);
                    txt_art.setText(message);
                    new ArticleImage.DownloadImageFromInternet((ImageView) findViewById(R.id.img_article))
                            .execute(message);
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
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
