package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText et1 , et2 , et3 , et4 , et5 , et6 , et7 , et8;
    Button signUp,signIn;
    DatabaseReference dbRef1;
    User us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //create notification channel
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        et1 = findViewById(R.id.name);
        et2 = findViewById(R.id.pass);
        et3 = findViewById(R.id.email);
        et4 = findViewById(R.id.dob);
        et5 = findViewById(R.id.nic);
        et6 = findViewById(R.id.gender);
        et7 = findViewById(R.id.tel);
        et8 = findViewById(R.id.address);

        signUp = findViewById(R.id.signup);

        us = new User();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //notification code
                NotificationCompat.Builder builder = new NotificationCompat.Builder(SignUp.this,"My notification");
                builder.setContentTitle("Signed Up Successfully");
                builder.setContentText("Dear Customer, You Just Signed Up to our application. Thank you..!");
                builder.setSmallIcon(R.drawable.covid);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(SignUp.this);
                managerCompat.notify(3,builder.build());

                dbRef1 = FirebaseDatabase.getInstance().getReference().child("User");

                try{
                    if(TextUtils.isEmpty(et1.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(et2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a password",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(et3.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a email",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(et4.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a date",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(et5.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a nic",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(et6.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a gender",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(et7.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(et8.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a address",Toast.LENGTH_SHORT).show();
                    else{
                        us.setUsername(et1.getText().toString().trim());
                        us.setPassword(et2.getText().toString().trim());
                        us.setEmail(et3.getText().toString().trim());
                        us.setDob(et4.getText().toString().trim());
                        us.setNic(et5.getText().toString().trim());
                        us.setGender(et6.getText().toString().trim());
                        us.setTel(Integer.parseInt(et7.getText().toString().trim()));
                        us.setAddress(et8.getText().toString().trim());

                        dbRef1.push().setValue(us);
                        //dbRef.child("Bk1").setValue(bk);
                        Toast.makeText(getApplicationContext(),"Signed Up Successfully!",Toast.LENGTH_SHORT).show();
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
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        et7.setText("");
        et8.setText("");
    }
    protected void onResume() {
        signIn = findViewById(R.id.signIn);
        super.onResume();

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
            }
        });
}
}