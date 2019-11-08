package main.java.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import main.java.model.Setting;

import java.util.UUID;

public class SettingsUIElement {

    private UUID ID;
    private String name;
    private String value;
    private String description;
    private boolean readonly;

    private GridPane pane;

    // https://stackoverflow.com/questions/43877557/the-correct-way-to-handle-and-extend-node-in-javafx
    public SettingsUIElement(String name, String value) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.value = value;
        initUIElement();
    }

    public SettingsUIElement(Setting setting) {
        this.ID = UUID.randomUUID();
        this.name = setting.getName();
        this.value = setting.getValue();
        initUIElement();
    }

    private void initUIElement() {

        Label labelName = new Label(name);
        TextField labelValue = new TextField(value);

        GridPane grid = new GridPane();

        // Add format to columns
        //grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        col0.setPrefWidth(100);
        col1.setFillWidth(true);
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().addAll(col0,col1);



        // Add UI elements to grid
        GridPane.setConstraints(labelName,0,0);
        GridPane.setConstraints(labelValue,1,0);
        grid.getChildren().addAll(labelName, labelValue);


        this.pane = grid;

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

    public GridPane asPane() {
        return this.pane;
    }

    @Override
    public String toString() {
        return "Setting: "+this.name + "=" + this.value;
    }
}
