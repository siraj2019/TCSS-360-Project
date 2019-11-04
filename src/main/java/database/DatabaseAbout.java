package main.java.database;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAbout implements DatabaseObjects {

    @Override
    public List<String> get() {
        List <String> returnList = new ArrayList<>();
        String filename = "testfile.csv";
        BufferedReader br = null;
        String line = "";
        String token = ",";
        
        try {
            
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                
                String[] data = line.split(token);
                
                //System.out.println(data[0]);
                
                returnList.add(data[0]);
            }
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return returnList;
    }

}
