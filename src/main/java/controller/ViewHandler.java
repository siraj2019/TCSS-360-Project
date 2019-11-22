package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import main.java.model.FileEntity;
import main.java.model.Setting;
import main.java.model.Tag;

public class ViewHandler {
    private ObservableSet<FileEntity> entitySet;
    private ObservableSet<Tag> columnTagSet;

    public ViewHandler() {
        this.entitySet = FXCollections.observableSet();
        Setting colSetting = Controllers.settingsHandler.getSetting("Columns");
        if(colSetting.getType() == ObservableSet.class) {
            this.columnTagSet = (ObservableSet<Tag>) colSetting.getValue();
        }

    }

    public ObservableSet<FileEntity> getEntitySet() {
        return entitySet;
    }

    //TODO: update current folder in folder tree


    //TODO: Update view when folder entered

    //TODO: update entity list when filter or current folder changes

    //TODO: update/delete/add documents from UI actions, including batch actions.


}
