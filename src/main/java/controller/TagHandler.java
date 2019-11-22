package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import main.java.model.Tag;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class TagHandler {
    //TODO: Create master list of tags and update methods

    private ObservableSet<Tag> requiredTagSet;
    private ObservableSet<Tag> tagSet;
    private HashSet<Tag> tagSetRequiredDocument;
    private HashSet<Tag> tagSetRequiredFileEntity;

    public TagHandler() {
        this.tagSet = FXCollections.observableSet();
        this.requiredTagSet = FXCollections.observableSet();
        this.tagSetRequiredDocument = new HashSet<Tag>();
        this.tagSetRequiredFileEntity = new HashSet<Tag>();

        // Tags added below here will be assigned to the following sets:
        requiredTagSet.add(new Tag<String>("Name", null));
        requiredTagSet.add(new Tag<String>("Root Folder", null));
        // Tags added above here will be added to the required tags for File Entities
        this.tagSetRequiredFileEntity.addAll(requiredTagSet);

        requiredTagSet.add(new Tag<File>("File", null));
        requiredTagSet.add(new Tag<Date>("CreatedDate", null));
        // Tags added above here will be added to the required tags for Documents
        this.tagSetRequiredDocument.addAll(Objects.requireNonNull(this.requiredTagSet));

        // Adds all required tags to the tag set.
        // All future tags should be added to the tag set, not the required tags.
        this.tagSet.addAll(this.requiredTagSet);
    }

    public HashSet<Tag> getTagSetRequiredDocument() {
        return tagSetRequiredDocument;
    }

    public HashSet<Tag> getTagSetRequiredFileEntity() {
        return tagSetRequiredFileEntity;
    }

    public ObservableSet<Tag> getTags() {
        return this.tagSet;
    }

    private void addTag(Tag tag) {
        this.requiredTagSet.add(tag);
    }

    public void removeTag(Tag tag) {
        if(!this.requiredTagSet.contains(tag)){
            this.requiredTagSet.remove(tag);
        } else{
            System.console().printf("Tag in required tag set: " + tag);
        }
    }
}
