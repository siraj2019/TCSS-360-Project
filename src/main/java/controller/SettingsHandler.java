package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import main.java.model.Setting;

public class SettingsHandler {

    private ObservableSet<Setting> settingList ;

    public SettingsHandler() {
        this.settingList = FXCollections.observableSet();
    }

    //https://www.tutorialspoint.com/java/util/observable_addobserver.htm
    public void addSetting(Setting setting) {
        settingList.add(setting);
    }

    public void updateSetting(Setting setting, String newValue) {
        for (Setting settingInSet: this.settingList
             ) {
            if (setting.equals(settingInSet)) {
                settingInSet.setValue(newValue);
            }
        }
    }

    // Maintains a list of all settings.
    public ObservableSet<Setting> getSettings() {
        return settingList;
    }

    //TODO: Create method to export settingsList to a JSON file.

    //TODO: Create method to overwrite settingsList with settings from JSON file.
}
