package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class pcr4 extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,price;
Button total,save,delete;
PCR_Booking PCR_bk;
DatabaseReference pRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcr4);

        Intent newIntent = getIntent();
        String n2 = newIntent.getStringExtra("EXTRA_MESSAGE1");
        String s2 = newIntent.getStringExtra("EXTRA_MESSAGE2");
        String s3 = newIntent.getStringExtra("EXTRA_MESSAGE3");
        String s4 = newIntent.getStringExtra("EXTRA_MESSAGE4");
        String s5 = newIntent.getStringExtra("EXTRA_MESSAGE5");
        String s6 = newIntent.getStringExtra("EXTRA_MESSAGE6");
        String s7 = newIntent.getStringExtra("EXTRA_MESSAGE7");
        String s8 = newIntent.getStringExtra("EXTRA_MESSAGE8");
        String s9 = newIntent.getStringExtra("EXTRA_MESSAGE9");
        String s10 = newIntent.getStringExtra("EXTRA_MESSAGE10");

        total = findViewById(R.id.btnTotalAmount);

        price = findViewById(R.id.edtTotalAmount);
        e1 = findViewById(R.id.edtHNamePayment);
        e2 = findViewById(R.id.edtFNamePayment);
        e3 = findViewById(R.id.edtlNamePayment);
        e4 = findViewById(R.id.edtNICPayment);
        e5 = findViewById(R.id.edtAddressPayment);
        e6 = findViewById(R.id.edtPhonePayment);
        e7 = findViewById(R.id.edtEmailPayment);
        e8 = findViewById(R.id.edtNationalityPayment);
        e9 = findViewById(R.id.edtDatePayment);
        e10 = findViewById(R.id.edtNuOfPatientsPayment);


        e1.setText(n2);
        e2.setText(s2);
        e3.setText(s3);
        e4.setText(s4);
        e5.setText(s5);
        e6.setText(s6);
        e7.setText(s7);
        e8.setText(s8);
        e9.setText(s9);
        e10.setText(s10);

        save = findViewById(R.id.btnSave);
        delete = findViewById(R.id.btnDelete);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Multiplication();
            }
        });


        PCR_bk = new PCR_Booking();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pRef = FirebaseDatabase.getInstance().getReference().child("PCR_Booking");

                try{
                    if(TextUtils.isEmpty(e1.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter hospital name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter first name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e3.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter last name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e4.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter nic",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e5.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter address",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e6.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a tel number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e7.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a email",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e8.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter nationality",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e9.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter date ",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(e10.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter number of patients ",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(price.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter price",Toast.LENGTH_SHORT).show();
                    else{
                        PCR_bk.setHospitalName(e1.getText().toString().trim());
                        PCR_bk.setFirstName(e2.getText().toString().trim());
                        PCR_bk.setLastName(e3.getText().toString().trim());
                        PCR_bk.setNic(e4.getText().toString().trim());
                        PCR_bk.setAddress(e5.getText().toString().trim());
                        PCR_bk.setTelephone(Integer.parseInt(e6.getText().toString().trim()));
                        PCR_bk.setEmail(e7.getText().toString().trim());
                        PCR_bk.setNationality(e8.getText().toString().trim());
                        PCR_bk.setDate(e9.getText().toString().trim());
                        PCR_bk.setNoOfPatients(e10.getText().toString().trim());
                        PCR_bk.setTotalPrice(price.getText().toString().trim());

                        pRef.push().setValue(PCR_bk);
                        //dbRef.child("Bk1").setValue(bk);
                        Toast.makeText(getApplicationContext(),"Saved Successfully!",Toast.LENGTH_SHORT).show();
                        clearControls();

                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Please enter a number in here",Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("PCR_Booking");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("PCR_Bk1")){
                            pRef = FirebaseDatabase.getInstance().getReference().child("PCR_Booking").child("PCR_Bk1");
                            pRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Deleted Successfully!",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No sourse to delete!",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }

    private void clearControls(){
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");
        e8.setText("");
        e9.setText("");
        e10.setText("");
        price.setText("");
    }

    public void Multiplication(){
        int no2 = 500;
        int no1 = Integer.parseInt(e10.getText().toString());
        if(no1 >= 3){
            int tot = no1 * no2 - (no1 * no2 /100 * 10);
            price.setText(String.valueOf(tot));
            Toast.makeText(this, "You got 10 % discount", Toast.LENGTH_SHORT).show();
        }else {

            int tot = no1 * no2;
            price.setText(String.valueOf(tot));
        }
    }
}