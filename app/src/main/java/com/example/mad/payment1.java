package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payment1 extends AppCompatActivity {

    TextView tv20, tv46;
    Button btnnn20, btnnn21, btnnn80;
    ImageView imag8;
    DatabaseReference dbRef2;
    Amount amo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);


        tv46 = findViewById(R.id.textView46);
        tv20 = findViewById(R.id.textView5);
        btnnn20 = findViewById(R.id.button22);
        btnnn21 = findViewById(R.id.button24);
        btnnn80 = findViewById(R.id.but1);
        imag8 = findViewById(R.id.iv4);

        amo = new Amount();

        Intent intent = getIntent();

        String amount = intent.getStringExtra("AMOUNT");

        tv20.setText("Amount: "+amount);

        btnnn80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef2 = FirebaseDatabase.getInstance().getReference().child("Amount");

                try {
                    if (TextUtils.isEmpty(tv46.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Display your name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(tv20.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Display your amount", Toast.LENGTH_SHORT).show();


                    else {
                        amo.setName(tv46.getText().toString().trim());
                        amo.setAmount(tv20.getText().toString().trim());



                        dbRef2.push().setValue(amo);
                        //dbRef.child("Bk1").setValue(bk);
                        Toast.makeText(getApplicationContext(), "Successfully!", Toast.LENGTH_SHORT).show();
                        clearControls();

                        //Intent intent = new Intent(payment2.this,payment4.class);
                        //startActivity(intent);

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter a number in here", Toast.LENGTH_SHORT).show();
                }
            }
        });


        imag8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment1.this,Home.class);
                startActivity(intent);
            }
        });

        btnnn80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
    private void clearControls() {
        tv46.setText("");
        tv20.setText("");


    }
}