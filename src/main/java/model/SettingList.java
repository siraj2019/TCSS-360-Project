package main.java.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class SettingList {
    private HashSet<Setting> settings;

    public SettingList() {
        this.settings = new HashSet<Setting>();
    }

    public HashSet<Setting> getSettings() {
        return settings;
    }

    public HashSet<Setting> getExportableSettings() {
        HashSet filteredSettings = new HashSet<Setting>();
        for (Setting setting: this.settings) {
            if (setting.isExportable())
                filteredSettings.add(setting);
        }
        return filteredSettings;
    }


    public void addSetting(Setting setting) {
        this.settings.add(Objects.requireNonNull(setting));
    }


    public void getSetting(String ID) {
    }

    public void getSetting(UUID ID){

    }
}
