package main.java.model;

import main.java.controller.Controllers;

import java.io.File;
import java.util.Objects;

public class Document extends FileEntity {

    private File file;

    public Document(String name, File file, Folder parent) {
        super(name, parent);
        this.file = file;

        this.setTags(Controllers.tagHandler.getTagSetRequiredDocument());
        initTags();
    }

    protected void initTags() {
        super.initTags();
        this.getTag("File").setValue(this.file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = Objects.requireNonNull(file);
        this.getTag("File").setValue(this.file);
    }


    @Override
    public String toString() {
        return "DOC" + this.getName() + " " + this.file.getName() + " " + this.tags.size() + " Tags";
    }
}
