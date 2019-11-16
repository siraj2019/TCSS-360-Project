package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import main.java.model.Tag;

import java.util.Date;

public class TagHandler {
    //TODO: Create master list of tags and update methods

    ObservableSet<Tag> tagSet;

    public TagHandler() {
        this.tagSet = FXCollections.observableSet();
    }

    public ObservableSet<Tag> getTags() {
        return this.tagSet;
    }

    private void addTag(Tag tag) {
        this.tagSet.add(tag);
    }

    public void addStringTag(String name, String value){
        this.addTag(new Tag(name, value, String.class));
    }

    public void addDateTag(String name, Date value) {
        this.addTag(new Tag(name, value, Date.class));
    }

    public void removeTag(Tag tag) {
        this.tagSet.remove(tag);
    }

    public void updateTag(Tag tag, Object value) {
        tag.setValue(value);
    }
}
