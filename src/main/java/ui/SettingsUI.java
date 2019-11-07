package main.java.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import main.java.model.Version;


public class SettingsUI extends Application implements MenuItemInterface {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Settings");
        VBox settingsPane = new VBox();

        Label label = new Label("This is the settings section.");

        Popup settingsPopup = new Popup();

        settingsPopup.getContent().add(label);

        label.setPrefHeight(300);
        label.setPrefWidth(500);

        Scene scene = new Scene(settingsPane, 300, 500);

        // Add About popup to main scene.
        initSettingsPane(settingsPane);

        // Launches main UI screen
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initSettingsPane(VBox rootPane) {
        Text textBlock = new Text("Settings Text");
        try {
            rootPane.getChildren().add(new SettingsUIElement("Setting Name", "TEST", "Description text.").asPane());
        } catch (Exception e) {
            textBlock.setText(e.getMessage());
            rootPane.getChildren().add(textBlock);
        }
    }

    public void initMenu(Menu rootMenu) {
        MenuItem aboutMenuItem = new MenuItem("Settings");
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(new Stage());
            }
        });
        rootMenu.getItems().add(aboutMenuItem);
    }
}
