package main.java.model;

import java.util.UUID;

public class Tag implements Cloneable, Comparable<Tag> {

    private UUID id;
    private String name;
    private Object value;
    private Class type;

    public Tag(String name, Object value, Class type) {
        this.generateID();
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public Tag(String name, Object value, Class type, UUID id) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public Tag(Tag other) {
        this.id = other.getID();
        this.name = other.getName();
        this.value = other.getValue();
        this.type = other.getType();
    }

    public Tag clone(Tag other) {
        return new Tag(other);
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

    public Class getType() {
        return this.type;
    }

    @Override
    public int compareTo(Tag o) {
        if(this.name.equals(o.getName()) &&
        this.type == o.getType() &&
        this.value == o.getValue()) {
            return 0;
        }
        return -1;
    }
}
