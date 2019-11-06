package main.java.model;

import java.util.HashSet;
import java.util.UUID;

public class SettingList {
    private HashSet<Setting> settings;

    public SettingList() {
        this.settings = new HashSet<Setting>();
    }

    public HashSet<Setting> getSettings() {
        return settings;
    }

    public void setSettings(HashSet<Setting> settings) {
        this.settings = settings;
    }


    public void getSetting(String ID) {
    }

    public void getSetting(UUID ID){

    }
}
