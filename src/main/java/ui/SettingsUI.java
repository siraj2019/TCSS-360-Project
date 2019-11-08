package main.java.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import main.java.controller.Controllers;
import main.java.controller.SettingsHandler;
import main.java.model.Setting;


public class SettingsUI extends Application implements MenuItemInterface {

    SettingsHandler settingsHandler;

    @Override
    public void start(Stage primaryStage) {

        this.settingsHandler = Controllers.settingsHandler;
        primaryStage.setTitle("Settings");
        BorderPane settingsPane = new BorderPane();

        Label label = new Label("This is the settings section.");

        Popup settingsPopup = new Popup();

        settingsPopup.getContent().add(label);

        label.setPrefHeight(300);
        label.setPrefWidth(500);

        Scene scene = new Scene(settingsPane, 300, 500);

        // Add Settings list to popup
        initSettingsPane(settingsPane);

        initBottomPane(settingsPane);

        // Launches main UI screen
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initSettingsPane(BorderPane rootPane) {
        Text textBlock = new Text("Settings Text");
        settingsHandler.addSetting(new Setting("TEST1", "VAL1"));
        System.out.println( settingsHandler.getSettings().isEmpty());
        try {
            ObservableList<GridPane> panes = FXCollections.observableArrayList();

            for (Setting setting : settingsHandler.getSettings()
                 ) {
                SettingsUIElement element = new SettingsUIElement(setting);
                panes.add(element.asPane());
                System.out.println(element.toString());;
            }

            ListView<GridPane> settingsList = new ListView<GridPane>(panes);
            settingsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            rootPane.setCenter(settingsList);



        } catch (Exception e) {
            textBlock.setText(e.getMessage());
            rootPane.getChildren().add(textBlock);
        }
    }

    private void initBottomPane(BorderPane rootPane){
        ButtonBar buttonBar = new ButtonBar();
        Button importSettingsButton = new Button("Import");
        Button exportSettingsButton = new Button("Export");
        buttonBar.getButtons().addAll(importSettingsButton, exportSettingsButton);

        rootPane.setBottom(buttonBar);
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
