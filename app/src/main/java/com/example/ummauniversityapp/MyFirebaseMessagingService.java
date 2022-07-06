package com.example.ummauniversityapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {

        String title = message.getNotification().getTitle();
        String text = message.getNotification().getBody();

        final String CHANNEL_ID = "NEW_ITEM";

        NotificationChannel notificationChannel = new NotificationChannel(
                CHANNEL_ID,
                "new item notification"
                , NotificationManager.IMPORTANCE_HIGH
        );


        getSystemService(NotificationManager.class).createNotificationChannel(notificationChannel);

        Notification.Builder notification = new Notification.Builder(this,CHANNEL_ID);
        notification.setContentText(text);
        notification.setContentTitle(title);
        notification.setSmallIcon(R.drawable.ic_baseline_feed_24);
        notification.setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(1, notification.build());


        super.onMessageReceived(message);


    }
}

