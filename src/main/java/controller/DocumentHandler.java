package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.model.Document;
import main.java.model.Folder;

import java.io.File;

public class DocumentHandler {
    ObservableList<Document> documentSet;

    public DocumentHandler() {
        this.documentSet = FXCollections.observableArrayList();
    }

    public ObservableList<Document> getDocuments() {
        return this.documentSet;
    }

    public void addDocument(Document document) {
        this.documentSet.add(document);
    }

    public void removeDocument(Document document) {
        this.documentSet.remove(document);
    }

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
