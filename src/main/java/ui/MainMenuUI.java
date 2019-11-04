package main.java.ui;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Objects;

public class MainMenuUI {

    protected Menu menu;
    MenuBar menubar;
    private LinkedList<MenuItem> menuItemList;

    public void start(BorderPane primaryPane) {
        menu = new Menu();
        menubar = new MenuBar();
        menubar.prefWidthProperty().bind(primaryPane.widthProperty());
        VBox box = new VBox(menubar);
        box.prefWidthProperty().bind(primaryPane.widthProperty());
        primaryPane.setTop(box);
    }

    public void addMenu(Menu menu){
        this.menubar.getMenus().add(Objects.requireNonNull(menu));
    }

    public void addMenuItem(Menu menu, MenuItem item) {
        try {
            this.menu.getItems().add(Objects.requireNonNull(item));
        } catch (Exception e) {
            //TODO: Create error logging
        }
    }
}
