package main.java.model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import main.java.controller.Controllers;

import java.io.File;
import java.util.Objects;

/**
 * Documents are a type of File Entity that points to a particular file.
 * Documents are file type agnostic.
 * Only one file can be represented in each document.
 */
public class Document extends FileEntity {

    private File file;

    /**
     * Default constructor
     * @param name
     * @param file
     * @param parent
     */
    public Document(String name, File file, Folder parent) {
        super(name, parent);
        this.file = file;

        this.setTags(Controllers.tagHandler.getTagSetRequiredDocument());
        this.initTags();
    }

    @Override
    protected void initTags() {
        super.initTags();
        this.getTag("File").setValue(this.file);
    }

    /**
     * Returns the document's File, or null if the file does not exist.
     * Makes no guarantees about the file's readability.
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     * Link this document to a file.
     * Makes no guarantees about the file's readability
     * @param file a non-null File
     */
    public void setFile(File file) {
        this.file = Objects.requireNonNull(file);
        this.getTag("File").setValue(this.file);
    }

    /**
     * Gets the document's File as a property.
     * Properties are for use in JavaFX UIs.
     * Changes to the File will automatically update in the UI table.
     * @return "file" property
     */
    public Property fileProperty() {
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
                return "file";
            }

            @Override
            public void addListener(ChangeListener changeListener) {

            }

            @Override
            public void removeListener(ChangeListener changeListener) {

            }

            @Override
            public Object getValue() {
                return file;
            }

            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void setValue(Object o) {

            }
        };
    }


    @Override
    public String toString() {
        return "DOC" + this.getName() + " " + this.file.getName() + " " + this.tags.size() + " Tags";
    }
}
