package main.java.model;

import java.util.UUID;

public class Setting implements Comparable<Setting> {
    private UUID ID;
    private String name;
    private Object value;
    private Class type;
    private boolean exportable;

    public Setting(String name, Object value, Class type) {
        generateID();
        this.name = name;
        this.value = value;
        this.type = type;
        this.exportable = true;
    }

    public Setting(String name, Object value, Class type, boolean exportable) {
        generateID();
        this.name = name;
        this.value = value;
        this.type = type;
        this.exportable = exportable;
    }

    public Setting(UUID id, String name, Object value, Class type, boolean exportable) {
        this.ID = id;
        this.name = name;
        this.value = value;
        this.type = type;
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

    public Object getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Class getType() {
        return this.type;
    }

    public boolean isExportable() {
        return exportable;
    }

    public void setExportable(boolean exportable) {
        this.exportable = exportable;
    }

    @Override
    public int compareTo(Setting o) {
        return this.ID.compareTo(o.getID());
    }

    public int compareByName(String name) {
        return this.name.compareToIgnoreCase(name);
    }

    public int compareByName(Setting o) {
        if (this.name.compareToIgnoreCase(o.getName())==0 &&
                this.type == o.getType()) {
            return 0;
        } else {
            return -1;
        }
    }


    @Override
    public String toString() {
        return "Setting:" + this.name + "=" + this.value;
    }
}
