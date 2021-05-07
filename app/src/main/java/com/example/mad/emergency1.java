package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class emergency1 extends AppCompatActivity {

    Button btnnn1, btnnn2, btnnn3, btnnn4, btnnn5;
    ImageButton imagebtn2;
    EditText etvv1;
    TextView tvv1, tvv2;
    DatabaseReference Reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency1);

        btnnn1 = findViewById(R.id.btnn1);
        btnnn2 = findViewById(R.id.btnn2);
        btnnn3 = findViewById(R.id.btnn3);
        btnnn4 = findViewById(R.id.btnn4);
        btnnn5 = findViewById(R.id.btnn5);
        imagebtn2 = findViewById(R.id.imageButton20);
        etvv1 = findViewById(R.id.etv1);
        tvv1 = findViewById(R.id.tv1);
        tvv2 = findViewById(R.id.tv2);

        imagebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(emergency1.this,Home.class);
                startActivity(intent);
            }
        });

        btnnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Reference = FirebaseDatabase.getInstance().getReference().child("User");

            }
        });
        btnnn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(emergency1.this,emergency2.class);
                startActivity(intent);
            }
        });

    }


}