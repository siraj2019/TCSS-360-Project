package main.java.model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.UUID;

public class Tag<T> implements Cloneable, Comparable<Tag> {

    private UUID id;
    private String name;
    private T value;

    public Tag(String name, T value) {
        this.generateID();
        this.name = name;
        this.value = value;
    }

    public Tag(String name, T value, UUID id) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Property<T> valueProperty() {
        return new ObjectProperty<T>() {
            @Override
            public void bind(ObservableValue<? extends T> observableValue) {

            }

            @Override
            public void unbind() {

            }

            @Override
            public boolean isBound() {
                return false;
            }

            @Override
            public Object getBean() {
                return null;
            }

            @Override
            public String getName() {
                return this.getName();
            }

            @Override
            public T get() {
                return this.getValue();
            }

            @Override
            public void addListener(ChangeListener<? super T> changeListener) {

            }

            @Override
            public void removeListener(ChangeListener<? super T> changeListener) {

            }

            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void set(T t) {

            }
        };
    }

    @Override
    public int compareTo(Tag o) {
        if(this.name.equals(o.getName()) &&
        this.value == o.getValue()) {
            return 0;
        }
        return -1;
    }
}
