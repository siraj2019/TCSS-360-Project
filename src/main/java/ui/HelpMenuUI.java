package main.java.ui;

import javafx.scene.control.Menu;

public class HelpMenuUI {
    public HelpMenuUI(Menu rootMenu) {

        // Creates About Popup.
        AboutUI about = new AboutUI();
        about.initMenu(rootMenu);
    }
}
