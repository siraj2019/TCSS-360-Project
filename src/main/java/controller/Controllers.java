package main.java.controller;

import main.db.DataSourceHandler;

/**
 * Contains all Handler objects.
 */
public class Controllers {

    public static DataSourceHandler dataSourceHandler;
    public static SettingsHandler settingsHandler;
    public static DocumentHandler documentHandler;
    public static ViewHandler viewHandler;
    public static TagHandler tagHandler;

    /**
     * Initializes new handlers
     */
    public Controllers() {

        dataSourceHandler = new DataSourceHandler();
        settingsHandler = new SettingsHandler();
        documentHandler = new DocumentHandler();
        viewHandler = new ViewHandler();
        tagHandler = new TagHandler();
    }
}
