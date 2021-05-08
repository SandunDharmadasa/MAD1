package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class vaccinate1 extends AppCompatActivity {

    EditText names;
    EditText nic;
    EditText date;
    EditText gender;
    EditText phone;
    EditText email;
    EditText address;
    EditText postalCode;
    EditText insuranceCompany;
    EditText insuranceID;
    Vaccine vaccine;
    DatabaseReference dbRef;

    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinate1);

        names = findViewById(R.id.name1);
        nic = findViewById(R.id.nic1);
        date = findViewById(R.id.date1);
        gender = findViewById(R.id.gender);
        phone = findViewById(R.id.phone1);
        email = findViewById(R.id.email1);
        address = findViewById(R.id.address1);
        postalCode = findViewById(R.id.postalCode);
        insuranceCompany = findViewById(R.id.insuranceCompany);
        insuranceID = findViewById(R.id.insuranceID);

        vaccine = new Vaccine();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("vaccine");

                try{
                    if(TextUtils.isEmpty(names.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(nic.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter NIC",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(date.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter birth date",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(gender.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter gender",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(phone.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter phone number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(email.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter an email",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(address.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter an address",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(postalCode.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter postal code",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(insuranceCompany.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your insurance company",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(insuranceID.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your insurance ID",Toast.LENGTH_SHORT).show();
                    else{
                        vaccine.setNames(names.getText().toString().trim());
                        vaccine.setNic(nic.getText().toString().trim());
                        vaccine.setDate(date.getText().toString().trim());
                        vaccine.setGender(gender.getText().toString().trim());
                        vaccine.setPhone(phone.getText().toString().trim());
                        vaccine.setEmail(email.getText().toString().trim());
                        vaccine.setAddress(address.getText().toString().trim());
                        vaccine.setPostalCode(postalCode.getText().toString().trim());
                        vaccine.setInsuranceCompany(insuranceCompany.getText().toString().trim());
                        vaccine.setInsuranceID(insuranceID.getText().toString().trim());

                        dbRef.push().setValue(vaccine);
                        //dbRef.child("Bk1").setValue(bk);
                        Toast.makeText(getApplicationContext(),"Inserted Successfully!",Toast.LENGTH_SHORT).show();
                        clearControls();

                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Please enter a number in here",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void clearControls(){
        names.setText("");
        nic.setText("");
        date.setText("");
        gender.setText("");
        phone.setText("");
        email.setText("");
        address.setText("");
        postalCode.setText("");
        insuranceCompany.setText("");
        insuranceID.setText("");
    }
}