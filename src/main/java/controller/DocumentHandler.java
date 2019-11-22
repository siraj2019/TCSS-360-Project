package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Document;
import main.java.model.Folder;

import java.io.File;

/**
 * Contains a master list of all documents in memory as well as
 * methods to add, remove, import, and export documents from the master list.
 */
public class DocumentHandler {
    ObservableList<Document> documentSet;

    /**
     * Creates a new, empty document list.
     */
    public DocumentHandler() {
        this.documentSet = FXCollections.observableArrayList();
    }

    /**
     * Gets the master list
     * @return the list of documents
     */
    public ObservableList<Document> getDocuments() {
        return this.documentSet;
    }

    /**
     * Adds a document to the master list
     * @param document Doc to add
     */
    public void addDocument(Document document) {
        this.documentSet.add(document);
    }

    /**
     * REmvoes a document from the master list of it exists in the list.
     * @param document Doc to remove
     */
    public void removeDocument(Document document) {
        this.documentSet.remove(document);
    }

    /**
     * Creates a document from the required information and adds the document to the master list.
     * @param name Document display name
     * @param file File to bind to the Document
     * @param parent parent folder, or null if root folder.
     */
    public void importDocument(String name, File file, Folder parent) {
        try{
            if(!file.exists() || !file.canRead() || file.isDirectory()) {
                throw new IllegalAccessException();
            } else {
                this.documentSet.add(new Document(name, file, parent));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
