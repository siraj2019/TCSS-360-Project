package main.java.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import main.java.controller.SettingsHandler;
import main.java.model.Setting;


public class SettingsUI extends Application implements MenuItemInterface {

    SettingsHandler settingsHandler;

    @Override
    public void start(Stage primaryStage) {

        this.settingsHandler = new SettingsHandler();
        primaryStage.setTitle("Settings");
        StackPane settingsPane = new StackPane();

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

    private void initSettingsPane(StackPane rootPane) {
        Text textBlock = new Text("Settings Text");
        settingsHandler.addSetting(new Setting("TEST1", "VAL1"));
        System.out.println( settingsHandler.getSettings().isEmpty());
        try {
            ObservableList<Pane> panes = FXCollections.observableArrayList();
            for (SettingsUIElement element : settingsHandler.getSettingsUIElements()
                 ) {
                panes.add(element.asPane());
                System.out.println(element.toString());;
            }

            ListView<Pane> settingsList = new ListView<Pane>(panes);
            settingsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            rootPane.getChildren().add(settingsList);



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
