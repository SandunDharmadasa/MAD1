package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class payment1 extends AppCompatActivity {

    TextView tv20;
    Button btnnn20, btnnn21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);

        tv20 = findViewById(R.id.textView5);
        btnnn20 = findViewById(R.id.button22);
        btnnn21 = findViewById(R.id.button24);

        btnnn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment1.this,payment3.class);
                startActivity(intent);
            }
        });

        btnnn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment1.this,payment2.class);
                startActivity(intent);
            }
        });


    }
}