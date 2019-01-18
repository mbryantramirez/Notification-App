package com.example.Notification_App_HW_Fabian_Kelveen.model;

public class DBCharacterCreator {
    private String characterName;
    private String characterImage;

    public DBCharacterCreator(String characterName, String characterImage){
        this.characterName = characterName;
        this.characterImage = characterImage;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterImage() {
        return characterImage;
    }

}
