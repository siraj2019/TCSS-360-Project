package main.java.model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import main.java.controller.Controllers;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

public class FileEntity {
    private UUID id;
    private String name;
    private Folder parentFolder;
    protected HashSet<Tag> tags;

    public FileEntity(String name, Folder parent) {
        this.generateId();
        this.name = name;
        this.parentFolder = parent;
        this.tags = new HashSet<Tag>();
        this.setTags(Controllers.tagHandler.getTagSetRequiredFileEntity());
    }

    public FileEntity(String name, Folder parent, UUID id) {
        this.id = id;
        this.name = name;
        this.parentFolder = parent;
        this.tags = new HashSet<Tag>();
        this.setTags(Controllers.tagHandler.getTagSetRequiredFileEntity());
    }

    protected void initTags() {
        this.getTag("Name").setValue(this.name);
        this.getTag("Root Folder").setValue(this.parentFolder);
    }

    public HashSet<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(Objects.requireNonNull(tag));
    }

    public void removeTag(Tag tag) {
        this.tags.remove(Objects.requireNonNull(tag));
    }

    public Tag getTag(String name){
        Stream<Tag> filter = this.tags.stream().filter(t -> t.getName().compareToIgnoreCase(name)==0);
        return filter.findFirst().get();
    }

    public void setTags(HashSet<Tag> tags) {
        this.tags.addAll(tags);
    }

    public UUID getId() {
        return id;
    }

    public void generateId() {
        this.id = UUID.randomUUID();
    }

    public void setId(UUID id) {

    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.getTag("Name").setValue(this.name);
    }

    public Property nameProperty() {
        return new Property() {
            @Override
            public void bind(ObservableValue observableValue) {

            }

            @Override
            public void unbind() {

            }

            @Override
            public boolean isBound() {
                return false;
            }

            @Override
            public void bindBidirectional(Property property) {

            }

            @Override
            public void unbindBidirectional(Property property) {

            }

            @Override
            public Object getBean() {
                return null;
            }

            @Override
            public String getName() {
                return "name";
            }

            @Override
            public void addListener(ChangeListener changeListener) {

            }

            @Override
            public void removeListener(ChangeListener changeListener) {

            }

            @Override
            public Object getValue() {
                return name;
            }

            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void setValue(Object o) {
                this.setValue(o);
            }
        };
    }

    @Override
    public String toString() {
        return "Entity" + this.getName();
    }

}
