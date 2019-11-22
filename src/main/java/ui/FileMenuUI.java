package main.java.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import main.java.actions.ImportFileDialogAction;
import main.java.model.Folder;

public class FileMenuUI {
    public FileMenuUI(Menu rootMenu) {
        // Import Button
        MenuItem importButton = new MenuItem("Import File...");
        importButton.addEventHandler(ActionEvent.ACTION, new ImportFileDialogAction(new Folder("root", null)));
        rootMenu.getItems().add(importButton);

        // Settings Button
        SettingsUI settings = new SettingsUI();
        settings.initMenu(rootMenu);
    }
}
