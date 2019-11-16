package main.java.controller;

public class Controllers {

    public static SettingsHandler settingsHandler;
    public static DocumentHandler documentHandler;

    public Controllers() {

        settingsHandler = new SettingsHandler();
        documentHandler = new DocumentHandler();
    }
}
