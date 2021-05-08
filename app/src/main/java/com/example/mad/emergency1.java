package com.example.mad;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class emergency1  extends AppCompatActivity {

    Button btnnn1, btnnn2, btnnn3, btnnn4, btnnn5;
    ImageButton imagebtn2;
    EditText etvvv1 , etvvv2, etvvv3, etvvv4;
    DatabaseReference dbRef1;
    Ambulance ambulance;

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
        etvvv1 = findViewById(R.id.etvv1);
        etvvv2 = findViewById(R.id.etvv2);
        etvvv3 = findViewById(R.id.etvv3);
        etvvv3 = findViewById(R.id.etvv4);

        ambulance = new Ambulance();
        

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
                dbRef1 = FirebaseDatabase.getInstance().getReference().child("Ambulance");

                try{
                    if(TextUtils.isEmpty(etvvv1.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvvv2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Phone Number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvvv3.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Address",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvvv4.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Number of Ambulance",Toast.LENGTH_SHORT).show();
                    else{
                        ambulance.setName(etvvv1.getText().toString().trim());
                        ambulance.setPhoneNumber(etvvv2.getText().toString().trim());
                        ambulance.setAddress(etvvv3.getText().toString().trim());
                        ambulance.setAmNumber(etvvv4.getText().toString().trim());

                        dbRef1.push().setValue(ambulance);
                        //dbRef.child("Bk1").setValue(bk);
                        Toast.makeText(getApplicationContext(),"Successfully!",Toast.LENGTH_SHORT).show();
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
        etvvv1.setText("");
        etvvv2.setText("");
        etvvv3.setText("");
        etvvv4.setText("");

    }



}