package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class vaccinate2 extends AppCompatActivity {

    EditText text1;
    EditText medication;
    EditText dosage;
    EditText allergic;
    EditText total;


    Button button2;
    Button button4;
    Button button5;
    Button button6;


    private Object id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinate2);

        text1 = findViewById(R.id.text1);
        medication = findViewById(R.id.medication);
        dosage = findViewById(R.id.dosage);
        allergic = findViewById(R.id.allergic);
        button2 = findViewById(R.id.button2);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(vaccinate2.this, vaccinate1.class));
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                medication.setText("");
                dosage.setText("");
                allergic.setText("");


            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doCalc();
            }

            private void doCalc() {

            }

            {
            }

            ;

        });


        {
            int no1 = Integer.parseInt(text1.getText().toString());
            int no2 = 3000;
            int tot = no1 * no2;


            total.setText(String.valueOf(tot));


        }
    }}