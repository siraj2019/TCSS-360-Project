import java.util.ArrayList;
import java.util.List;

public class databaseAbout implements databaseObjects {

    @Override
    public List<String> get() {
        List<String> returnList = new ArrayList<String>();

        returnList.add("Leif");
        returnList.add("Jesse");
        returnList.add("Siraj");
        returnList.add("Abdul");

        return returnList;
    }

}