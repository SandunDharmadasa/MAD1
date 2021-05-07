package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class emergency2 extends AppCompatActivity {

    Button btnnn6, btnnn7, btnnn8, btnnn9;
    ImageButton imagebtn20;
    TextView tvv3, tvv4;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency2);

        btnnn6 = findViewById(R.id.btnn6);
        btnnn7 = findViewById(R.id.btnn7);
        btnnn8 = findViewById(R.id.btnn8);
        btnnn9 = findViewById(R.id.btnn9);
        imagebtn20 = findViewById(R.id.imageButton20);
        tvv3 = findViewById(R.id.tv3);
        tvv4 = findViewById(R.id.tv4);

        imagebtn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(emergency2.this,emergency1.class);
                startActivity(intent);
            }
        });

        btnnn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvv3.setText(Integer.toString(counter));
            }
        });

        btnnn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter <= 0){
                    counter = 0;
                }else{
                    counter--;
                    tvv3.setText(Integer.toString(counter));
                }
            }
        });
        btnnn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mu = Integer.parseInt(tvv3.getText().toString()) * 2500;
                tvv4.setText("results is "+mu);
            }
        });

    }

}