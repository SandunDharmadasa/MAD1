package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class pcr2 extends AppCompatActivity {
    Button Book_btn1 , Book_btn2 , Book_btn3 , Book_btn4 , Book_btn5 , Book_btn6;
    TextView hospital_1_Name ,hospital_2_Name ,hospital_3_Name,hospital_4_Name,hospital_5_Name,hospital_6_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcr2);

        Book_btn1 = findViewById(R.id.bookNowBtn1);
        Book_btn2 = findViewById(R.id.bookNowBtn2);
        Book_btn3 = findViewById(R.id.bookNowBtn3);
        Book_btn4 = findViewById(R.id.bookNowBtn4);
        Book_btn5 = findViewById(R.id.bookNowBtn5);
        Book_btn6 = findViewById(R.id.bookNowBtn6);
    }
    public void goFormActivity_1(View view){
        Intent intent = new Intent(this, pcr3.class);
        hospital_1_Name = findViewById(R.id.hospitalName_1);
        String n1 = hospital_1_Name.getText().toString();
        intent.putExtra("EXTRA_MESSAGE1", n1);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }
    public void goFormActivity_2(View view){
        Intent intent = new Intent(this, pcr3.class);
        hospital_2_Name = findViewById(R.id.hospitalName_2);
        String n1 = hospital_2_Name.getText().toString();
        intent.putExtra("EXTRA_MESSAGE1", n1);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }
    public void goFormActivity_3(View view){
        Intent intent = new Intent(this, pcr3.class);
        hospital_3_Name = findViewById(R.id.hospitalName_3);
        String n1 = hospital_3_Name.getText().toString();
        intent.putExtra("EXTRA_MESSAGE1", n1);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }
    public void goFormActivity_4(View view){
        Intent intent = new Intent(this, pcr3.class);
        hospital_4_Name = findViewById(R.id.hospitalName_4);
        String n1 = hospital_4_Name.getText().toString();
        intent.putExtra("EXTRA_MESSAGE1", n1);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }
    public void goFormActivity_5(View view){
        Intent intent = new Intent(this, pcr3.class);
        hospital_5_Name = findViewById(R.id.hospitalName_5);
        String n1 = hospital_5_Name.getText().toString();
        intent.putExtra("EXTRA_MESSAGE1", n1);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }
    public void goFormActivity_6(View view){
        Intent intent = new Intent(this, pcr3.class);
        hospital_6_Name = findViewById(R.id.hospitalName_6);
        String n1 = hospital_6_Name.getText().toString();
        intent.putExtra("EXTRA_MESSAGE1", n1);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "You just clicked the Book Now button", Toast.LENGTH_LONG).show();
    }

}