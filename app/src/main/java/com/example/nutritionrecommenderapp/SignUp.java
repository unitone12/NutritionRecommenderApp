package com.example.nutritionrecommenderapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText edt_name, edt_semail, edt_spassword, edt_age, edt_height;
    Spinner dis_spin, gen_spin;
    Button btn_submit;
    TextView txt_login;

    String disease, gender;
    String sname, semail, spassword, sage, sheight;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edt_name = findViewById(R.id.name);
        edt_semail = findViewById(R.id.sign_email);
        edt_spassword = findViewById(R.id.sign_passwrod);
        edt_age = findViewById(R.id.sign_age);
        edt_height = findViewById(R.id.sign_height);
        dis_spin = findViewById(R.id.disease_spin);
        gen_spin = findViewById(R.id.gender_spin);
        btn_submit = findViewById(R.id.submit);
        txt_login = findViewById(R.id.register);

        final String[] Dis_Spin = {"Select Disease", "Diabetes", "Heart Patient", "Dehydration", "Iron Deficiency Anemia", "Starvation",
                "Calcium Deficiency", "Ketosis", "Xerophthalmic (Vitamin A)", "Rickets (Vitamin D)", "Beriberi (Thiamin)", "Pellagra (Niacin)",
                "Scurry (Vitamin C)", "VKDB (Vitamin K)", "Physically Weak", "Fat (Heavy Weight)"};

        ArrayAdapter<String> dis_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Dis_Spin);
        dis_spin.setAdapter(dis_Adapter);

        final String[] Gen_Spin = {"Select Gender", "Male", "Female"};

        ArrayAdapter<String> gen_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Gen_Spin);
        gen_spin.setAdapter(gen_Adapter);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_submit.setOnClickListener(this);
        txt_login.setOnClickListener(this);

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        dis_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Toast.makeText(getApplicationContext(), "Please choose disease", Toast.LENGTH_SHORT).show();
                }
                else {
                    disease = Dis_Spin[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gen_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Toast.makeText(getApplicationContext(), "Please choose gender", Toast.LENGTH_SHORT).show();
                }
                else {
                    gender = Gen_Spin[position];
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        semail = edt_semail.getText().toString();
        spassword = edt_spassword.getText().toString();
        sage = edt_age.getText().toString();
        sname = edt_name.getText().toString();
        sheight = edt_height.getText().toString();

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (!semail.isEmpty() && !spassword.isEmpty() && !sage.isEmpty() && !sname.isEmpty() && !sheight.isEmpty() && !disease.isEmpty() && !gender.isEmpty()) {

            if (v == btn_submit) {
                firebaseAuth.createUserWithEmailAndPassword(semail, spassword)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "SignUp Successfully", Toast.LENGTH_LONG).show();

                                    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                                    databaseReference.child("userdata").child(firebaseUser.getUid()).child("UserName").setValue(sname)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (!task.isSuccessful()) {
                                                        Toast.makeText(SignUp.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                    databaseReference.child("userdata").child(firebaseUser.getUid()).child("UserAge").setValue(sage)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (!task.isSuccessful()) {
                                                        Toast.makeText(SignUp.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                        databaseReference.child("userdata").child(firebaseUser.getUid()).child("UserWeight").setValue(sheight)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (!task.isSuccessful()) {
                                                            Toast.makeText(SignUp.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });


                                        databaseReference.child("userdata").child(firebaseUser.getUid()).child("UserDisease").setValue(disease)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (!task.isSuccessful()) {
                                                        Toast.makeText(SignUp.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                    databaseReference.child("userdata").child(firebaseUser.getUid()).child("UserGender").setValue(gender)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (!task.isSuccessful()) {
                                                        Toast.makeText(SignUp.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                        Toast.makeText(getApplicationContext(), "Data Saved!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);

                                }

                                else{
                                    Toast.makeText(getApplicationContext(), "no " + task.getException(), Toast.LENGTH_LONG).show();
                                }

                            }
                        });

            }
        }

        else {
            edt_age.setError("Empty");
            edt_semail.setError("Empty");
            edt_spassword.setError("Empty");
            edt_name.setError("Empty");
            edt_height.setError("Empty");
        }

    }
}