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

import java.io.InvalidClassException;
import java.util.Date;

/**
 * Main Document list UI
 * Displays file entities in the main window in a table.
 * Table columns are based on properties of the entities, such as name, file, etc.
 */
public class ViewUI{

    private DocumentHandler docHandler;
    private TableView<Document> viewList;
    private ObservableSet<Tag> colTags;
    private ObservableSet<TableColumn> colSet;
    private Document selectedDocument;

    /**
     * Default constructor
     * @param rootPane link to the root pane where this table should be displayed.
     */
    public void start(BorderPane rootPane) {
        this.docHandler = Controllers.documentHandler;
        this.colTags = FXCollections.observableSet();
        this.colSet = FXCollections.observableSet();
        this.selectedDocument = null;
        this.initDocList(rootPane);
    }

    /**
     * Updates and sets columns, sets initial parameters, and displays the table in the rootPane.
     * @param rootPane link to the root pane where this table should be displayed.
     */
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

    /**
     * Gets the list of tags to create columns with from the settings handler's "Columns" setting.
     * If no columns exist in the setting, update the setting with the default required tags from the TagHandler.
     * @throws InvalidClassException
     */
    public void setColumns() throws InvalidClassException {
        Setting<ObservableSet> settingColumns = Controllers.settingsHandler.getSetting("Columns");
        if (settingColumns.getValue().isEmpty()) {
            settingColumns.getValue().addAll(Controllers.tagHandler.getTagSetRequiredFileEntity());
        }
        this.colTags = (ObservableSet<Tag>) settingColumns.getValue();
    }

    /**
     * Creates the columns from the column tags and binds them to the table.
     */
    public void updateColumns() {

        // Name Column
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<FileEntity,String>("name")
        );
        viewList.getColumns().add(nameColumn);

        // File Column
        TableColumn fileColumn = new TableColumn("Date");
        fileColumn.setCellValueFactory(
                new PropertyValueFactory<FileEntity, Date>("date")
        );
        viewList.getColumns().add(fileColumn);

        // Project
        TableColumn newCol = new TableColumn("Project");
        newCol.setCellValueFactory(
                new PropertyValueFactory<FileEntity, String>("project")
        );
        viewList.getColumns().add(newCol);

    }
}
