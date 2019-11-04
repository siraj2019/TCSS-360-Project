package main.java.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class AboutUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("About");
        TilePane mainPane = new TilePane();

        Label label = new Label("This is the About section.");

        Popup aboutPopup = new Popup();

        aboutPopup.getContent().add(label);

        label.setPrefHeight(200);
        label.setPrefWidth(150);

        Scene scene = new Scene(mainPane, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
