package com.example.timezone;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;

import androidx.annotation.NonNull;

public class timeZone extends BroadcastReceiver {
    private static final String CHANNEL_ID = "TimeZoneChannel";
    private static final int NOTIFICATION_ID = 1;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_TIMEZONE_CHANGED.equals(intent.getAction())) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Time Change Channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Channel for time changes");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            notificationManager.createNotificationChannel(channel);

            Notification.Builder builder = new Notification.Builder(context, CHANNEL_ID)
                    .setContentTitle("Time Zone Changed")
                    .setContentText("Часовой пояс был изменен")
                    .setSmallIcon(android.R.drawable.ic_dialog_alert);

            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
