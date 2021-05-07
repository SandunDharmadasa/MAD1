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

public class payment3 extends AppCompatActivity {

    EditText etvv2, etvv3, etvv4, etvv5;
    Button btnnn10;
    DatabaseReference dbRef;
    visa vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment3);

        etvv2 = findViewById(R.id.etv10);
        etvv3 = findViewById(R.id.etv1);
        etvv4 = findViewById(R.id.editTextDate);
        etvv5 = findViewById(R.id.editTextTextPassword);
        btnnn10 = findViewById(R.id.btnn2);

        btnnn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("VISA_MASTER");

                try{
                    if(TextUtils.isEmpty(etvv2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a card number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvv3.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a cardholder name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvv4.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a expire date",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(etvv5.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a security code",Toast.LENGTH_SHORT).show();

                    else{
                        vi.setCard_number(etvv2.getText().toString().trim());
                        vi.setCardholder_name(etvv3.getText().toString().trim());
                        vi.setExpire_date(etvv4.getText().toString().trim());
                        vi.setSecurity_code(etvv5.getText().toString().trim());


                        dbRef.push().setValue(vi);
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
        etvv2.setText("");
        etvv3.setText("");
        etvv4.setText("");
        etvv5.setText("");

    }
}