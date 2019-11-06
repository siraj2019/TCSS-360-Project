package main.java.model;

import java.util.UUID;

public class Setting {
    private UUID ID;
    private String name;
    private String value;
    private boolean exportable;

    public Setting(String name, String value) {
        generateID();
        this.name = name;
        this.value = value;
        this.exportable = true;
    }

    public Setting(String name, String value, boolean exportable) {
        generateID();
        this.name = name;
        this.value = value;
        this.exportable = exportable;
    }

    public UUID getID() {
        return ID;
    }

    public void generateID() {
        this.ID = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return "Default Value";
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isExportable() {
        return exportable;
    }

    public void setExportable(boolean exportable) {
        this.exportable = exportable;
    }
}
