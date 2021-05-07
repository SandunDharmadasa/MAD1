package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payment2 extends AppCompatActivity {

    EditText etvv6, etvv7, etvv8, etvv9;
    Button btnnn11;
    DatabaseReference dbRef2;
    Web web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);

        etvv6 = findViewById(R.id.etv10);
        etvv7 = findViewById(R.id.etv1);
        etvv8 = findViewById(R.id.etv11);
        etvv9 = findViewById(R.id.etv12);
        btnnn11 = findViewById(R.id.btnn2);

        btnnn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef2 = FirebaseDatabase.getInstance().getReference().child("Web_Money");

                try{
                    if(TextUtils.isEmpty(etvv6.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a account number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvv7.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a bank name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvv8.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a branch of the bank",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvv9.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a transaction number",Toast.LENGTH_SHORT).show();

                    else{
                        web.setAccount_number(etvv6.getText().toString().trim());
                        web.setBank_name(etvv7.getText().toString().trim());
                        web.setBranchOfThe_bank(etvv8.getText().toString().trim());
                        web.setTrans_number(etvv9.getText().toString().trim());


                        dbRef2.push().setValue(web);
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
        etvv6.setText("");
        etvv7.setText("");
        etvv8.setText("");
        etvv9.setText("");

    }
}