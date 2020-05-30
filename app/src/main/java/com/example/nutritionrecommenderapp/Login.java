package com.example.nutritionrecommenderapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText edt_email, edt_passwrod;
    Button btn_login;
    TextView txt_signup, forget;
    int state;
    int count = 0;
    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edt_email = findViewById(R.id.email);
        edt_passwrod = findViewById(R.id.passwrod);
        btn_login = findViewById(R.id.login);
        txt_signup = findViewById(R.id.signup);
        forget = findViewById(R.id.forget);
        progressBar = findViewById(R.id.progress);

        SharedPreferences sharedPreferences = getSharedPreferences("logout", Context.MODE_PRIVATE);
        state = sharedPreferences.getInt("ok", 0);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null && state != 0){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DoubleBounce doublebounce = new DoubleBounce();
                progressBar.setIndeterminateDrawable(doublebounce);


                String email = edt_email.getText().toString();
                String password = edt_passwrod.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
                else {
                    edt_email.setError("Empty");
                    edt_passwrod.setError("Empty");
                }
            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}
