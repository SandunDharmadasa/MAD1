package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1 , btn2 , btn3 , btn4;
    TextView t1 , t2 , t3 , na1 , na2 , na3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button8);
        btn2 = findViewById(R.id.h1);
        btn3 = findViewById(R.id.h2);
        btn4 = findViewById(R.id.h3);


    }

    public void go2SecondActivity1(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        t1 = findViewById(R.id.h1p);
        na1 = findViewById(R.id.h1n);
        String n9 = t1.getText().toString();
        String n10 = na1.getText().toString();
        intent.putExtra("EXTRA_MESSAGE9", n9);
        intent.putExtra("EXTRA_MESSAGE10", n10);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }

    public void go2SecondActivity2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        t2 = findViewById(R.id.h2p);
        na2 = findViewById(R.id.h2n);
        String n9 = t2.getText().toString();
        String n10 = na2.getText().toString();
        intent.putExtra("EXTRA_MESSAGE9", n9);
        intent.putExtra("EXTRA_MESSAGE10", n10);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }

    public void go2SecondActivity3(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        t3 = findViewById(R.id.h3p);
        na3 = findViewById(R.id.h3n);
        String n9 = t3.getText().toString();
        String n10 = na3.getText().toString();
        intent.putExtra("EXTRA_MESSAGE9", n9);
        intent.putExtra("EXTRA_MESSAGE10", n10);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }
}