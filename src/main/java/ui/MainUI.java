package main.java.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.plaf.MenuBarUI;
import java.io.IOException;

public class MainUI extends Application {

    private Stage primaryStage;
    private BorderPane rootBorder;
    private String programTitle;
    private MainMenuUI mainMenu;

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

        // Creates Main Menu.
        // Must be before any element that adds a menu item.
        initMainMenu();

        // Help Menu
        Menu helpMenu = new Menu("Help");
        this.mainMenu.addMenu(helpMenu);

        // Creates About Popup.
        AboutUI about = new AboutUI();
        MenuItem aboutMenuItem = new Menu("About");
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                about.start(new Stage());
            }
        });
        helpMenu.getItems().add(aboutMenuItem);



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

    private void initMainMenu() {
        MainMenuUI menu = new MainMenuUI();
        menu.start(rootBorder);
        this.mainMenu = menu;
    }
}

