package main.java.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SettingsUIElementTest {

    SettingsUIElement element;



    @BeforeEach
    void setUp() {
        this.element = new SettingsUIElement("TEST", "TESTVAL");
    }

    @Test
    void asPane() {
    }

    @Test
    void testToString() {
        System.out.println(element.toString());
    }
}