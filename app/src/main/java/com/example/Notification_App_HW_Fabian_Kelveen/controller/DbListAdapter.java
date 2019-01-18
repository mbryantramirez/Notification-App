package com.example.Notification_App_HW_Fabian_Kelveen.controller;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.Notification_App_HW_Fabian_Kelveen.DisplayContent;
import com.example.Notification_App_HW_Fabian_Kelveen.MainActivity;
import com.example.Notification_App_HW_Fabian_Kelveen.R;
import com.example.Notification_App_HW_Fabian_Kelveen.model.DBCharacterCreator;
import com.example.Notification_App_HW_Fabian_Kelveen.view.DbListViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DbListAdapter extends RecyclerView.Adapter<DbListViewHolder> {
    private List<DBCharacterCreator> characterList;
    private LayoutInflater inflater;

    public DbListAdapter(List<DBCharacterCreator> characterList, Context context){
        this.characterList = characterList;
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public DbListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.list_content, viewGroup, false);
        return new DbListViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DbListViewHolder holder, final int i) {
        String characterNames = characterList.get(i).getCharacterName();

        holder.characterListView.setText(characterNames);
        holder.characterListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayContent.class);
                intent.putExtra("charName", characterList.get(i).getCharacterName());
                intent.putExtra("charImg", characterList.get(i).getCharacterImage());
                characterList.clear();
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d("SIZE","getItemCount Size: " + characterList.size());
        return characterList.size();
    }



}
