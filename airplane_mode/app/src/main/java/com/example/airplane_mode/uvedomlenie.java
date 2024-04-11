package com.example.airplane_mode;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class uvedomlenie extends BroadcastReceiver {
    private static final String CHANNEL_ID = "AirplaneModeChannel";
    private static final int NOTIFICATION_ID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Airplane Mode Channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }

            Notification.Builder builder = new Notification.Builder(context, CHANNEL_ID)
                    .setContentTitle("Airplane Mode")
                    .setContentText(isAirplaneModeOn ? "Включен" : "Выключен")
                    .setSmallIcon(android.R.drawable.ic_dialog_info);

            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
