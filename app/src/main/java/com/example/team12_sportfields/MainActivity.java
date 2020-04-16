package com.example.team12_sportfields;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView mainTxt;
    FirebaseUser user;
    private FirebaseAuth fAuth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        InitializeFields();

        String name = user.getEmail();
        String name2 = user.getProviderId();
        mainTxt.setText("Welcome " + name + " and " + name2);




    }

    private void InitializeFields() {
        mainTxt = findViewById(R.id.tvMainText);

    }

    public void logout(View view){
        dbRef = database.getReference("/message");
        String currentUserID = fAuth.getCurrentUser().getUid();
        dbRef.child("test").child("data").child("message1").setValue("Goodbye");
        System.out.println("user1 id = " + currentUserID);

        /*
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();*/
    }

/*
    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("hasBackPressed",true);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
*/


}
