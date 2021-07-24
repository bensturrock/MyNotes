package com.example.myassessment.controller;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myassessment.R;
import com.example.myassessment.second_activity;

public class Notify {
    public static void showNotification(second_activity second_activity) { //show notifications

        String varNotification = second_activity.title_txt.getText().toString(); //converts textView to string varNotification for note title
        String varNotificationDesc = second_activity.description_txt.getText().toString(); //converts textView to string varNotification for note description

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(second_activity, com.example.myassessment.second_activity.CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24) //use Notification vector asset
                        .setContentTitle("New Note Saved: "+ varNotification) //set Notification title
                        .setContentText(varNotificationDesc) //set Notification body
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority to default priority
        NotificationManagerCompat mNotificationManager = NotificationManagerCompat.from(second_activity); //compatibility for older devices
        mNotificationManager.notify(1, mBuilder.build());
    }
}
