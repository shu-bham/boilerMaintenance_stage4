package com.example.boilermaintenance;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("fcmme1", "data : " + remoteMessage.getData().get("title") + remoteMessage.getData().get("body"));
        Log.d("fcmme2", "notif : " + remoteMessage.getNotification().getTitle() + remoteMessage.getNotification().getBody());

        sendNotification(remoteMessage);


    }

    private void sendNotification(RemoteMessage remoteMessage){

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "EDMTDev";

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.o){
//            @SuppressLint("WrongConstant")
//                    NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
//                    "EDMT Notification ",
//                    NotificationManager.IMPORTANCE_MAX);
//
//            notificationChannel.setDescription("EDMTDev channel for app test");
//            notificationChannel.enableLights(true);
//            notificationChannel.setLightColor(Color.RED);
//            notificationChannel.setVibrationPattern(new long[](0,1000,500,1000));
//            notificationChannel.enableVibration(true);
//            notificationManager.createNotificationChannel(notificationChannel);
//        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(android.support.v4.R.drawable.notification_icon_background)
                .setTicker("Hearty365")
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setContentInfo("Tap for more details");


        notificationManager.notify(1,notificationBuilder.build());
    }


}
