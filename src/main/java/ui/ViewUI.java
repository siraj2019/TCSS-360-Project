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
import main.java.model.FileEntity;
import main.java.model.Setting;
import main.java.model.Tag;

import java.io.File;
import java.io.InvalidClassException;

/**
 * Main Document list UI
 */
public class ViewUI{

    private DocumentHandler docHandler;
    private TableView<Document> viewList;
    private ObservableSet<Tag> colTags;
    private ObservableSet<TableColumn> colSet;
    private Document selectedDocument;

    public void start(BorderPane rootPane) {
        this.docHandler = Controllers.documentHandler;
        this.colTags = FXCollections.observableSet();
        this.colSet = FXCollections.observableSet();
        this.selectedDocument = null;
        this.initDocList(rootPane);
    }

    private void initDocList(BorderPane rootPane) {
        try{
            viewList = new TableView<Document>();

            rootPane.setCenter(viewList);

            // Sets Col names
            this.setColumns();
            this.updateColumns();

            viewList.setItems(docHandler.getDocuments());

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

    public void setColumns() throws InvalidClassException {
        Setting<ObservableSet> settingColumns = Controllers.settingsHandler.getSetting("Columns");
        if (settingColumns.getValue().isEmpty()) {
            settingColumns.getValue().addAll(Controllers.tagHandler.getTagSetRequiredFileEntity());
        }
        this.colTags = (ObservableSet<Tag>) settingColumns.getValue();
    }

    public void updateColumns() {

        // Name Column
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<FileEntity,String>("name")
        );
        viewList.getColumns().add(nameColumn);

        // File Column
        TableColumn fileColumn = new TableColumn("File");
        fileColumn.setCellValueFactory(
                new PropertyValueFactory<FileEntity, File>("file")
        );
        viewList.getColumns().add(fileColumn);
    }
}
