package com.example.Notification_App_HW_Fabian_Kelveen;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar();

        TextView textView = findViewById(R.id.charactername);
        ImageView imageView = findViewById(R.id.characterimage);

        String name = getIntent().getStringExtra("charName");
        String img = getIntent().getStringExtra("charImg");

        textView.setText(name);

        Picasso.get()
                .load(img)
                .into(imageView);
    }
}
