package com.example.Notification_App_HW_Fabian_Kelveen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Notification_App_HW_Fabian_Kelveen.controller.DbListAdapter;
import com.example.Notification_App_HW_Fabian_Kelveen.model.DBCharacterCreator;
import com.example.Notification_App_HW_Fabian_Kelveen.model.DragonballCharacters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    public static List<DBCharacterCreator> characterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        jsonDbCreator();
        //Log.d("SIZE", "Size: " + characterList.size());
        setRecyclerView();
    }

    public void jsonDbCreator(){
        try{
            JSONObject dbCharacters = new JSONObject(DragonballCharacters.dbChars);
            JSONArray characters = dbCharacters.getJSONArray("characters");
            JSONArray characterImgs = dbCharacters.getJSONArray("characterimg");

            for(int i = 0; i < characters.length(); i++){
                String characterNames = characters.getString(i);
                String characterImages = characterImgs
                        .getJSONObject(i)
                        .getString(characters.getString(i).toLowerCase());
                characterList.add(new DBCharacterCreator(characterNames, characterImages));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    public void setRecyclerView(){
        DbListAdapter adapter = new DbListAdapter(characterList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
/*FIXME:
1. Implement a Cardview for your list.
2. Create notifications that allow the user to trigger the characters power up.

 */