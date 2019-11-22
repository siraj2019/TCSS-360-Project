package main.java.model;

import java.util.Objects;
import java.util.UUID;

public class Setting<T> implements Comparable<Setting> {
    private UUID ID;
    private String name;
    private T value;
    private boolean exportable;

    public Setting(String name, T value) {
        generateID();
        this.name = name;
        this.value = value;
        this.exportable = true;
    }

    public Setting(String name, T value, boolean exportable) {
        generateID();
        this.name = name;
        this.value = value;
        this.exportable = exportable;
    }

    public Setting(UUID id, String name, T value, boolean exportable) {
        this.ID = id;
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

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        try{
            this.value = Objects.requireNonNull(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Class getType() {
        return value.getClass();
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
                this.getType() == o.getType()) {
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
