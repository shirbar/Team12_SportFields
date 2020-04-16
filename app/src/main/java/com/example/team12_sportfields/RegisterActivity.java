package com.example.team12_sportfields;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText mFullName, mEmail, mPassword, mPhone;
    Button registerBtn;
    TextView loginTxt;
    ProgressBar progressBar;
    private FirebaseAuth fAuth;
    private DatabaseReference RootRef;

    /*public RegisterActivity(Context mMockContext) {

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fAuth = FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference("sportfields-86ef9");


        InitializeFields();



    }

    private void InitializeFields() {
        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        registerBtn = findViewById(R.id.registerBtn);
        loginTxt = findViewById(R.id.loginTxt);
        mFullName = findViewById(R.id.fullName);
        progressBar = findViewById(R.id.progressBar);

    }

    public void loginPageClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public boolean test(){
        return true;
    }

    public void registerClick(View view) {



        final String fullname = mFullName.getText().toString().trim();
        final String phone = mPhone.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            mEmail.setError("Email is Required.");
            return;
        }
        if (TextUtils.isEmpty(password)){
            mPassword.setError("Email is Required.");
            return;
        }
        if(password.length() < 6){
            mPassword.setError("Password must contain at least 6 characters.");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){

                    String currentUserID = fAuth.getCurrentUser().getUid();
                    RootRef.child("Users").child(currentUserID).setValue("");

                    Toast.makeText(RegisterActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
