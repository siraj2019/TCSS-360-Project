package main.java.database;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAbout implements DatabaseObjects {

    @Override
    public List<String> get() {
        List<String> returnList = new ArrayList<>();

        returnList.add("Leif");
        returnList.add("Jesse");
        returnList.add("Siraj");
        returnList.add("Abdul");

        return returnList;
    }

}