package main.java.ui;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.UUID;

public class SettingsUIElement {

    private UUID ID;
    private String name;
    private String value;
    private String description;
    private boolean readonly;

    private Pane pane;

    // https://stackoverflow.com/questions/43877557/the-correct-way-to-handle-and-extend-node-in-javafx
    public SettingsUIElement(String name, String value, String description) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.value = value;
        this.description = description;

        Label labelName = new Label(name);
        Label labelValue = new Label(value);
        Label labelDescription = new Label(description);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(labelName, labelValue);

        this.pane = new HBox();
        this.pane.getChildren().add(hbox);

        this.pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                                  @Override
                                                  public void handle(MouseEvent mouseEvent) {
                                                      pane.setStyle("-fx-background-color:#dae7f3;");
                                                  }
                                              }
        );

        this.pane.setOnMouseExited(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {
                                            pane.setStyle("-fx-background-color:transparent;");
                                        }
                                    }
        );
    }

    public Pane asPane() {
        return this.pane;
    }
}
