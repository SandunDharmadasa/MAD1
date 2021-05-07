package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class emergency1 extends AppCompatActivity {

    Button btnnn1, btnnn2, btnnn3, btnnn4, btnnn5;
    EditText etvv1;
    TextView tvv1, tvv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency1);

        btnnn1 = findViewById(R.id.btnn1);
        btnnn2 = findViewById(R.id.btnn2);
        btnnn3 = findViewById(R.id.btnn3);
        btnnn4 = findViewById(R.id.btnn4);
        btnnn5 = findViewById(R.id.btnn5);
        etvv1 = findViewById(R.id.etv1);
        tvv1 = findViewById(R.id.tv1);
        tvv2 = findViewById(R.id.tv2);

    }
}