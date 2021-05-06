package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    Button signUp , quarantine , pcr , vaccine , emergency , payment , user;
    ImageButton fb , msg , ins , twt , wht , email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        signUp = findViewById(R.id.button23);
        quarantine = findViewById(R.id.button15);
        pcr = findViewById(R.id.button16);
        vaccine = findViewById(R.id.button14);
        emergency = findViewById(R.id.button12);
        payment = findViewById(R.id.button13);
        user = findViewById(R.id.button11);

        fb = findViewById(R.id.imageButton9);
        msg = findViewById(R.id.imageButton10);
        ins = findViewById(R.id.imageButton11);
        twt = findViewById(R.id.imageButton12);
        wht = findViewById(R.id.imageButton13);
        email = findViewById(R.id.imageButton14);
    }

    protected void onResume() {
        super.onResume();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,SignUp.class);
                startActivity(intent);
            }
        });

        quarantine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                startActivity(intent);
            }
        });

        pcr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,pcr1.class);
                startActivity(intent);
            }
        });

        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,vaccinate1.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,emergency1.class);
                startActivity(intent);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,payment1.class);
                startActivity(intent);
            }
        });



        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/");
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.messenger.com/");
            }
        });

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/");
            }
        });

        twt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://twitter.com/");
            }
        });

        wht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.whatsapp.com/");
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://mail.google.com/");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}