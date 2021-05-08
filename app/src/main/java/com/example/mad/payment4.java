package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class payment4 extends AppCompatActivity {

    ImageView imgv;
    Button btnnn30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment4);

        imgv = findViewById(R.id.iv4);
        btnnn30 = findViewById(R.id.btnn2);

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment4.this,payment3.class);
                startActivity(intent);
            }
        });

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment4.this,payment2.class);
                startActivity(intent);
            }
        });

        btnnn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment4.this,Home.class);
                startActivity(intent);
            }
        });

    }
}