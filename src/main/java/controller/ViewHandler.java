package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import main.java.model.FileEntity;

public class ViewHandler {
    private ObservableSet<FileEntity> entitySet;

    public ViewHandler() {
        this.entitySet = FXCollections.observableSet();
    }

    public ObservableSet<FileEntity> getEntitySet() {
        return entitySet;
    }

    //TODO: update current folder in folder tree


    //TODO: Update view when folder entered

    //TODO: update entity list when filter or current folder changes

    //TODO: update/delete/add documents from UI actions, including batch actions.


}
