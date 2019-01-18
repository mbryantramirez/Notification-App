package com.example.Notification_App_HW_Fabian_Kelveen.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.Notification_App_HW_Fabian_Kelveen.R;
import com.example.Notification_App_HW_Fabian_Kelveen.controller.DbListAdapter;

public class DbListViewHolder extends RecyclerView.ViewHolder{
    public final TextView characterListView;
    final DbListAdapter adapter;

    public DbListViewHolder(@NonNull View itemView, DbListAdapter adapter) {
        super(itemView);
        characterListView = itemView.findViewById(R.id.characterlist);
        this.adapter = adapter;
    }


}
