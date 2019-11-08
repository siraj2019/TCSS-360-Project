package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import main.java.model.Setting;

import java.util.Iterator;

public class SettingsHandler {

    private ObservableSet<Setting> settingList ;

    public SettingsHandler() {
        this.settingList = FXCollections.observableSet();
    }

    //https://www.tutorialspoint.com/java/util/observable_addobserver.htm
    public void addSetting(Setting setting) {
        settingList.add(setting);
    }

    public void updateSetting(Setting setting, String value) {
        for (Iterator<Setting> it = this.settingList.iterator(); it.hasNext();
             ) {
            Setting settingInSet = it.next();
            if (setting.equals(settingInSet)) {
                settingInSet.setValue(value);
            }
        }
    }

    // Maintains a list of all settings.
    public ObservableSet<Setting> getSettings() {
        return settingList;
    }


}
