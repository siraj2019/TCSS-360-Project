package main.java.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import main.java.controller.Controllers;
import main.java.controller.DocumentHandler;
import main.java.model.Document;
import main.java.model.Setting;

import java.io.InvalidClassException;

/**
 * Main Document list UI
 */
public class ViewUI{

    private DocumentHandler docHandler;
    private TableView<Document> viewList;
    private ObservableSet<String> colNames;
    private ObservableSet<TableColumn> colSet;
    private Document selectedDocument;

    public void start(BorderPane rootPane) {
        this.docHandler = Controllers.documentHandler;
        this.colNames = FXCollections.observableSet();
        this.colSet = FXCollections.observableSet();
        this.selectedDocument = null;
        this.initDocList(rootPane);
    }

    private void initDocList(BorderPane rootPane) {
        try{
            viewList = new TableView<Document>(docHandler.getDocuments());
            this.getColumns();
            rootPane.setCenter(viewList);

            // Sets Col names

            // Only select a single document at a time
            viewList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            // Listen to changes on the selected document
            viewList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Document>() {
                @Override
                public void changed(ObservableValue<? extends Document> observableValue, Document document, Document t1) {

                }
            });
            // Binds the selected document when focused.
            viewList.getFocusModel().focusedItemProperty().addListener(new ChangeListener<Document>() {
                @Override
                public void changed(ObservableValue<? extends Document> observableValue, Document document, Document t1) {
                    selectedDocument = t1;
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getColumns() throws InvalidClassException {
        Setting settingColumns = Controllers.settingsHandler.getSetting("Columns");
        if(settingColumns.getType() != ObservableSet.class) {
            throw new InvalidClassException("Expected Setting ObservableSet class, was " + settingColumns.getType());
        }
        this.colNames = (ObservableSet<String>) settingColumns.getValue();
    }

    public void updateColumns() {
        for (String s : this.colNames
             ) {
            TableColumn newCol = new TableColumn(s);
            newCol.setCellValueFactory(
                    new PropertyValueFactory<>(s)
            );
            this.colSet.add(newCol);
        }
    }
}
