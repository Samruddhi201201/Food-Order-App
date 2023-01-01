package com.example.practical05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    final String CHANNEL_ID="new_notification";
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //receiving arraylist from pasta class
        //ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("arrayList");
        b1=findViewById(R.id.notify);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creteNotification();
            }
        });
    }
    void creteNotification()
    {
        NotificationManager nm=(NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notification Example";
            String description = "This is a Demo";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            nm.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.bell)
                        .setContentTitle("Order Successful")
                        .setContentText("These are your order details");

        Intent notificationIntent = new Intent(this,
                Order_Details.class);
        notificationIntent.putExtra("notificationID", 0);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        nm.notify(0,builder.build());


    }
}