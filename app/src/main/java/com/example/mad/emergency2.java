package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class emergency2 extends AppCompatActivity {

    Button btnnn6, btnnn7, btnnn8;
    ImageButton imagebtn20;
    TextView tvv3, tvv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency2);

        btnnn6 = findViewById(R.id.btnn6);
        btnnn7 = findViewById(R.id.btnn7);
        btnnn8 = findViewById(R.id.btnn8);
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
    }
}