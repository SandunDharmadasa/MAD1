package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {

    TextView tv1 , tv2 , tv3 , tv4 , tv5 , tv6 , tv7 , tv8;
    Button save , delete , pay;
    DatabaseReference dbRef;
    Booking bk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //create notification channel
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Intent newIntent = getIntent();
        String n1 = newIntent.getStringExtra("EXTRA_MESSAGE1");
        String n2 = newIntent.getStringExtra("EXTRA_MESSAGE2");
        String n3 = newIntent.getStringExtra("EXTRA_MESSAGE3");
        String n4 = newIntent.getStringExtra("EXTRA_MESSAGE4");
        String n5 = newIntent.getStringExtra("EXTRA_MESSAGE5");
        String n6 = newIntent.getStringExtra("EXTRA_MESSAGE6");
        String n7 = newIntent.getStringExtra("EXTRA_MESSAGE7");
        String n8 = newIntent.getStringExtra("EXTRA_MESSAGE8");
        tv1 = findViewById(R.id.textV1);
        tv2 = findViewById(R.id.textV2);
        tv3 = findViewById(R.id.textV3);
        tv4 = findViewById(R.id.textV4);
        tv5 = findViewById(R.id.textV5);
        tv6 = findViewById(R.id.textV6);
        tv7 = findViewById(R.id.textV7);
        tv8 = findViewById(R.id.textV8);
        tv1.setText(n1);
        tv2.setText(n2);
        tv3.setText(n3);
        tv4.setText(n4);
        tv5.setText(n5);
        tv6.setText(n6);
        tv7.setText(n7);
        tv8.setText(n8);

        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);
        pay = findViewById(R.id.btnPay);

        bk = new Booking();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //notification code
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity3.this,"My notification");
                builder.setContentTitle("Hotel Booked Successfully");
                builder.setContentText("Your booking to the quarantine is successfully added. Thank you..!");
                builder.setSmallIcon(R.drawable.covid);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity3.this);
                managerCompat.notify(2,builder.build());

                dbRef = FirebaseDatabase.getInstance().getReference().child("Booking");
                try{
                    if(TextUtils.isEmpty(tv1.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(tv2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a date",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(tv3.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a date",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(tv4.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(tv5.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a nic",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(tv6.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a tel number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(tv7.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a price",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(tv8.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a hotel",Toast.LENGTH_SHORT).show();
                    else{
                        bk.setName(tv1.getText().toString().trim());
                        bk.setStartDate(tv2.getText().toString().trim());
                        bk.setEndDate(tv3.getText().toString().trim());
                        bk.setNoOfDays(tv4.getText().toString().trim());
                        bk.setNic(tv5.getText().toString().trim());
                        bk.setTel(Integer.parseInt(tv6.getText().toString().trim()));
                        bk.setPrice(tv7.getText().toString().trim());
                        bk.setHotel(tv8.getText().toString().trim());

                        //dbRef.push().setValue(bk);
                        dbRef.child("Bk1").setValue(bk);
                        Toast.makeText(getApplicationContext(),"Saved Successfully!",Toast.LENGTH_SHORT).show();

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
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Booking");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Bk1")){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Booking").child("Bk1");
                            dbRef.removeValue();
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
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");
        tv7.setText("");
        tv8.setText("");
    }

    protected void onResume() {
        super.onResume();

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, payment1.class);
                startActivity(intent);
            }
        });
    }
}