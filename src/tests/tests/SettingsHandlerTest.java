package tests;

import javafx.collections.ObservableSet;
import main.java.controller.SettingsHandler;
import main.java.model.Setting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SettingsHandlerTest {

    SettingsHandler handler;
    Setting setting0;

    @BeforeEach
    void setUp() {
        this.handler = new SettingsHandler();
        setting0 = new Setting("TEST", "VAL1");
    }

    @Test
    void addSetting() {
        this.handler.addSetting(setting0);
    }

    @Test
    void updateSetting() {
        this.addSetting();
        this.handler.updateSetting(setting0, "UpdatedVal");
    }

    @Test
    void getSettings() {
        this.addSetting();
        ObservableSet set = handler.getSettings();

    }
}