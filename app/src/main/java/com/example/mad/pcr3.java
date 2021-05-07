package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class pcr3 extends AppCompatActivity {
    EditText et1 ,fName,lName,nic,address,phone,email,nationality,date,numOfPatients;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcr3);

        Intent newIntent = getIntent();
        String n1 = newIntent.getStringExtra("EXTRA_MESSAGE1");

        //set hospital name
        et1 = findViewById(R.id.e1);
        et1.setText(n1);

    }

    public void shareDataToPcr4Page(View view){

        //Assign variables
        et1 = findViewById(R.id.e1);
        fName = findViewById(R.id.edtFirstNameForm);
        lName = findViewById(R.id.edtLastNameForm);
        nic = findViewById(R.id.edtNICForm);
        address  =findViewById(R.id.edtAddressForm);
        phone = findViewById(R.id.edtTelephoneForm);
        email = findViewById(R.id.edtEmailForm);
        nationality = findViewById(R.id.edtNationalityForm);
        date = findViewById(R.id.edtDateForm);
        numOfPatients = findViewById(R.id.edtNumberOfPatientsForm);

        book = findViewById(R.id.shareAllData);

        //intent
        Intent intent = new Intent(this, pcr4.class);

        //assign values to variables
        String n2 = et1.getText().toString();
        String s1 = fName.getText().toString();
        String s2 = lName.getText().toString();
        String s3 = nic.getText().toString();
        String s4 = address.getText().toString();
        String s5 = phone.getText().toString();
        String s6 = email.getText().toString();
        String s7 = nationality.getText().toString();
        String s8 = date.getText().toString();
        String s9 = numOfPatients.getText().toString();

        //pass values
        intent.putExtra("EXTRA_MESSAGE1", n2);
        intent.putExtra("EXTRA_MESSAGE2", s1);
        intent.putExtra("EXTRA_MESSAGE3", s2);
        intent.putExtra("EXTRA_MESSAGE4", s3);
        intent.putExtra("EXTRA_MESSAGE5", s4);
        intent.putExtra("EXTRA_MESSAGE6", s5);
        intent.putExtra("EXTRA_MESSAGE7", s6);
        intent.putExtra("EXTRA_MESSAGE8", s7);
        intent.putExtra("EXTRA_MESSAGE9", s8);
        intent.putExtra("EXTRA_MESSAGE10", s9);

        //start intent
        startActivity(intent);

        //toast message
        Toast.makeText(getApplicationContext(), "Check your data", Toast.LENGTH_LONG).show();

    }

}