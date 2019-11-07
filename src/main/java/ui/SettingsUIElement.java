package main.java.ui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.UUID;

public class SettingsUIElement {

    private UUID ID;
    private String name;
    private String value;
    private String description;
    private boolean readonly;

    private Pane pane;

    // https://stackoverflow.com/questions/43877557/the-correct-way-to-handle-and-extend-node-in-javafx
    public SettingsUIElement(String name, String value) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.value = value;

        Label labelName = new Label(name);
        TextField labelValue = new TextField(value);

        this.pane = new Pane();
        HBox hbox = new HBox();

        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(labelName, labelValue);

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

    @Override
    public String toString() {
        return "Setting: "+this.name + "=" + this.value;
    }
}
