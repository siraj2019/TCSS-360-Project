package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Setting;
import main.java.ui.SettingsUIElement;

import java.util.HashMap;

public class SettingsHandler {

    private ObservableList<Setting> settingList ;
    private ObservableList<SettingsUIElement> settingUIList;
    private HashMap<Setting, SettingsUIElement> settingMap = new HashMap<>();

    public SettingsHandler() {
        this.settingList = FXCollections.observableArrayList();
        settingUIList = FXCollections.observableArrayList();
        settingMap = new HashMap<Setting, SettingsUIElement>();
    }

    //https://www.tutorialspoint.com/java/util/observable_addobserver.htm
    public void addSetting(Setting setting) {
        settingList.add(setting);
        this.updateSettingsUIList();
    }

    // For every setting not mapped to a UI element, create a UI element and update the UI element list.
    private void updateSettingsUIList() {
        for (Setting setting: settingList
        ) {
            if(!settingMap.containsKey(setting)) {
                SettingsUIElement element = new SettingsUIElement(setting.getName(), setting.getValue());
                settingUIList.add(element);
                settingMap.put(setting,element);
            }

        }
    }

    // Maintains a list of all settings.
    public ObservableList<Setting> getSettings() {
        return settingList;
    }

    // Maintains a list of all setting UI elements.  UI will automatically update when this list is updated.
    public ObservableList<SettingsUIElement> getSettingsUIElements() {
        return settingUIList;
    }


}
