package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btn1 , btn2 , btn3;
    EditText et1 , et2 , et3 , et4 , et5 , et6 , et7 , et8 ;
    TextView price , tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent newIntent = getIntent();
        String n9 = newIntent.getStringExtra("EXTRA_MESSAGE9");
        String n10 = newIntent.getStringExtra("EXTRA_MESSAGE10");
        et4 = findViewById(R.id.editT4);
        et7 = findViewById(R.id.editT9);
        et8 = findViewById(R.id.editT10);
        et7.setText(n9);
        et8.setText(n10);

        btn2 = findViewById(R.id.button6);
        btn3 = findViewById(R.id.button3);
        btn1 = findViewById(R.id.button2);
        price = findViewById(R.id.total);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Multiplication();
            }
        });
    }

    public void go2SecondActivity(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        et1 = findViewById(R.id.editT1);
        et2 = findViewById(R.id.editT2);
        et3 = findViewById(R.id.editT3);

        et5 = findViewById(R.id.editT5);
        et6 = findViewById(R.id.editT6);
        tot = findViewById(R.id.total);
        et8 = findViewById(R.id.editT10);
        String n1 = et1.getText().toString();
        String n2 = et2.getText().toString();
        String n3 = et3.getText().toString();
        String n4 = et4.getText().toString();
        String n5 = et5.getText().toString();
        String n6 = et6.getText().toString();
        String n7 = tot.getText().toString();
        String n8 = et8.getText().toString();
        intent.putExtra("EXTRA_MESSAGE1", n1);
        intent.putExtra("EXTRA_MESSAGE2", n2);
        intent.putExtra("EXTRA_MESSAGE3", n3);
        intent.putExtra("EXTRA_MESSAGE4", n4);
        intent.putExtra("EXTRA_MESSAGE5", n5);
        intent.putExtra("EXTRA_MESSAGE6", n6);
        intent.putExtra("EXTRA_MESSAGE7", n7);
        intent.putExtra("EXTRA_MESSAGE8", n8);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();


    }

    public void Multiplication(){

        int no1 = Integer.parseInt(et4.getText().toString());
        int no2 = Integer.parseInt(et7.getText().toString());
        int tot = no1 * no2;

        price.setText(String.valueOf(tot));

    }

    protected void onResume() {
        super.onResume();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,Home.class);
                startActivity(intent);
            }
        });




    }
}