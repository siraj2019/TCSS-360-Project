package main.java.model;

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

    @Override
    public String toString() {
        return "Entity" + this.getName();
    }

}
