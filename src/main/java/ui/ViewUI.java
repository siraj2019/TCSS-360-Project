package main.java.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import main.java.controller.Controllers;
import main.java.controller.DocumentHandler;
import main.java.model.Document;

/**
 * Main Document list UI
 */
public class ViewUI{

    private DocumentHandler docHandler;

    private Document selectedDocument;

    public void start(BorderPane rootPane) {
        this.docHandler = Controllers.documentHandler;
        this.selectedDocument = null;
        this.initDocList(rootPane);
    }

    private void initDocList(BorderPane rootPane) {
        try{
            ListView<Document> viewList = new ListView<Document>(docHandler.getDocuments());

            rootPane.setCenter(viewList);

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
}
