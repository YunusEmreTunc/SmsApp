package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.button).setOnClickListener(view -> {
            startActivity(new Intent(SplashActivity.this,KayitActivity.class));
        });
        findViewById(R.id.button2).setOnClickListener(view -> {
            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
        });
    }
}