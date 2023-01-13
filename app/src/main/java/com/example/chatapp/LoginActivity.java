package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText editTextTextEmailAddress;
    EditText editTextTextPassword;
    Button button3;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.button4).setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,KayitActivity.class));
        });

        button3 = findViewById(R.id.button3);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

        mAuth = FirebaseAuth.getInstance();

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextTextEmailAddress.getText().toString();
                String password = editTextTextPassword.getText().toString();
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,AppActivity.class));
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Giriş Başarısız ", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}