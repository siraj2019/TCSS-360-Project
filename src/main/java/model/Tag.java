package main.java.model;

import java.util.UUID;

public class Tag {

    private UUID id;
    private String name;
    private Object value;
    private Class Type;

    public Tag(String name, Object value, Class type) {
        this.generateID();
        this.name = name;
        this.value = value;
        Type = type;
    }

    public Tag(String name, Object value, Class type, UUID id) {
        this.id = id;
        this.name = name;
        this.value = value;
        Type = type;
    }

    public UUID getID() {
        return id;
    }

    public void setID(UUID ID) {
        this.id = ID;
    }

    public void generateID() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
