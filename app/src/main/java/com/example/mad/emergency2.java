package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class emergency2 extends AppCompatActivity {

    Button btnnn6, btnnn7, btnnn8;
    TextView tvv3, tvv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency2);

        btnnn6 = findViewById(R.id.btnn6);
        btnnn7 = findViewById(R.id.btnn7);
        btnnn8 = findViewById(R.id.btnn8);
        tvv3 = findViewById(R.id.tv3);
        tvv4 = findViewById(R.id.tv4);
    }
}