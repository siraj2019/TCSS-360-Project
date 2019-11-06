package main.java.model;

import java.util.HashSet;

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
}
