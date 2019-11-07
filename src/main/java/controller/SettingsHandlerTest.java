package main.java.controller;

import main.java.model.Setting;

import static org.junit.jupiter.api.Assertions.fail;

class SettingsHandlerTest {

    SettingsHandler settingsHandler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.settingsHandler = new SettingsHandler();
    }

    @org.junit.jupiter.api.Test
    void addSetting() {
        this.settingsHandler.addSetting(new Setting("TEST1", "TESTVAL1"));
    }

    @org.junit.jupiter.api.Test
    void getSettings() {
        addSetting();
        if (settingsHandler.getSettings().isEmpty()) {
            fail("No Settings Added");
        }
        for (Setting s: settingsHandler.getSettings()
             ) {
            System.out.println();
        }
    }

    @org.junit.jupiter.api.Test
    void getSettingsUIElements() {
    }
}