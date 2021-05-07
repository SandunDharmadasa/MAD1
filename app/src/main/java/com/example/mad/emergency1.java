package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class emergency1 extends AppCompatActivity {

    Button btnnn1, btnnn2, btnnn3, btnnn4, btnnn5;
    EditText etvv1;
    TextView tvv1, tvv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency1);

        btnnn1 = findViewById(R.id.btnn1);
        btnnn2 = findViewById(R.id.btnn2);
        btnnn3 = findViewById(R.id.btnn3);
        btnnn4 = findViewById(R.id.btnn4);
        btnnn5 = findViewById(R.id.btnn5);
        etvv1 = findViewById(R.id.etv1);
        tvv1 = findViewById(R.id.tv1);
        tvv2 = findViewById(R.id.tv2);



    }
    private boolean validateUsername(){
        String val = etvv1.getEditableText().toString();

        if(val.isEmpty()){
            etvv1.setError("Field cannot be empty");
            return false;
        }else if(val.length() >= 10){
            etvv1.setError("Username too long");
            return false;
        }else{
            etvv1.setError(null);
            return true;
        }
    }
    public void loginUser(View view){
        if(!validateUsername() ){
            return;
        }
        else{
            isUser();
        }
    }

    private void isUser() {

        String userEnteredUsername = etvv1.getEditableText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");

        Query checkUser = reference.orderByChild("etvv1").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    etvv1.setError(null);

                    String userEnteredUsername = etvv1.getEditableText().toString().trim();
                    String usernameFromDB = snapshot.child(userEnteredUsername).child("etvv1").getValue(String.class);

                    if(usernameFromDB.equals(userEnteredUsername)){

                        etvv1.setError(null);

                        Integer telFromDB = snapshot.child(userEnteredUsername).child("tel").getValue(Integer.class);
                        String addressFromDB = snapshot.child(userEnteredUsername).child("address").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),emergency1.class);

                        intent.putExtra("tel" ,telFromDB);
                        intent.putExtra("address", addressFromDB);

                        startActivity(intent);
                    }else{
                        etvv1.setError("Wrong Username");
                        etvv1.requestFocus();
                    }

                }
                else{
                    etvv1.setError("Wrong Username");
                    etvv1.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void showAllUserData(){
        Intent intent = getIntent();
        int[] user_Telephone = intent.getIntArrayExtra("tel");
        String user_address = intent.getStringExtra("address");
    }

}