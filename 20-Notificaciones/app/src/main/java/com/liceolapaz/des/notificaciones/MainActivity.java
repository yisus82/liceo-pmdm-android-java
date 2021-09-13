package com.liceolapaz.des.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIF_ALERTA_ID = 1;
    private static final String CHANNEL_ID = "MiCanal";
    private Button btnNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        btnNotificacion = (Button) findViewById(R.id.BtnNotif);
        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                .setSmallIcon(android.R.drawable.stat_sys_warning)
                                .setLargeIcon((((BitmapDrawable) getResources()
                                        .getDrawable(R.drawable.ic_launcher)).getBitmap()))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                .setAutoCancel(true)
                                .setContentTitle("Mensaje de Alerta")
                                .setContentText("Ejemplo de notificación.")
                                .setContentInfo("4")
                                .setTicker("Alerta!");
                Intent notificationIntent =
                        new Intent(MainActivity.this, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(
                        MainActivity.this, 0, notificationIntent, 0);
                mBuilder.setContentIntent(contentIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
            }
        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}