package main.java.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUI extends Application {

    private Stage primaryStage;
    private BorderPane rootBorder;

    private String programTitle;

    /**
     * Sample taken from:
     * https://www.swtestacademy.com/getting-started-with-javafx/
     *
     *
     * Args expected:
     * 0    Program Title
     * 1
     */
    public void main(String[] args) {

        launch(args);
    }

    private void initUIVariables() {
        // Sets program title
        this.programTitle = "Document Management";
    }

    @Override
    public void start(Stage primaryStage) {
        initUIVariables();

        this.primaryStage = primaryStage;

        //Creates and initializes the main program window.
        initPrimaryStage();

        //Creates a frame in the primary stage
        initRootLayout();

        primaryStage.show();

    }


    private void initPrimaryStage() {
        //Sets program title
        primaryStage.setTitle(programTitle);
    }


    private void initRootLayout() {
        try {
            // Load xml layout into rootLayout pane
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("rootBorder.fxml"));
            rootBorder = loader.load();

            // Creates a scene from the root layout pane and add it to the main scene
            Scene scene = new Scene(rootBorder);
            primaryStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
