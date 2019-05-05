package com.example.boilermaintenance;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.*;

public class Sensor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();//boilermaintenance-17ea4.firebaseio.com/sensor/");

        Query query = reference.child("sensor").orderByChild("temp").equalTo(292);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        Toast.makeText(getApplicationContext(),issue.toString()+"hey",Toast.LENGTH_LONG).show();

                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel("default",
                                    "YOUR_CHANNEL_NAME",
                                    NotificationManager.IMPORTANCE_DEFAULT);
                            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
                            mNotificationManager.createNotificationChannel(channel);
                        }
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                                .setContentTitle("Check Temperature Level!") // title for notification
                                .setContentText("Boiler "+issue.getKey()+"is high")// message for notification
                                // set alarm sound for notification
                                .setAutoCancel(true); // clear notification after click

                        mNotificationManager.notify(0, mBuilder.build());


                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
