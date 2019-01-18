package com.example.Notification_App_HW_Fabian_Kelveen;


import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayContent extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 555;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar();
        ConstraintLayout layout = findViewById(R.id.constainlayout);
        TextView textView = findViewById(R.id.charactername);
        ImageView imageView = findViewById(R.id.characterimage);
        final NotificationCompat.Builder notifyBuilder = getNoticationBuilder();
        MainActivity.mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());



        String name = getIntent().getStringExtra("charName");
        String img = getIntent().getStringExtra("charImg");



        if(img != null || name != null){
            textView.setText(name);
            Picasso.get()
                    .load(img)
                    .into(imageView);
        }

    }

    private NotificationCompat.Builder getNoticationBuilder(){
        MediaPlayer soundFX = new MediaPlayer();
        Intent intent = new Intent(getApplicationContext(), DisplayContent.class);
        intent.putExtra("charImg", "https://vignette.wikia.nocookie.net/p__/images/0/02/Katopesla_render.png/revision/latest?cb=20180901155000&path-prefix=protagonist");
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(getApplicationContext(),
                NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getApplicationContext(), PRIMARY_CHANNEL_ID)
                .setContentTitle("AN ENEMY IS APPROACHING!")
                .setContentText("Click here to power up")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        return notifyBuilder;
    }
}
