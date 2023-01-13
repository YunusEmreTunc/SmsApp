package com.example.chatapp;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class KayitActivity extends AppCompatActivity {

    EditText editTextTextEmailAddress2;
    EditText editTextTextPassword2;
    Button button5;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        findViewById(R.id.button6).setOnClickListener(view -> {
            startActivity(new Intent(KayitActivity.this,LoginActivity.class));
        });

        button5 = findViewById(R.id.button5);
        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);

        mAuth = FirebaseAuth.getInstance();

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextTextEmailAddress2.getText().toString();
                String password = editTextTextPassword2.getText().toString();
                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(KayitActivity.this, "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(KayitActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(KayitActivity.this,AppActivity.class));
                    }
                    else{
                        Toast.makeText(KayitActivity.this, "Kayıt Başarısız ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    };
}