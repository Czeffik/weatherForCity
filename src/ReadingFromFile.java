import javafx.util.Pair;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadingFromFile {
    private Map<Pair<Integer, Double>, Map<Integer, Double>> mapToRead;
    private static int id = 0;

    public Map<Pair<Integer, Double>, Map<Integer, Double>> getMapToRead() {
        return mapToRead;
    }

    public ReadingFromFile(){
        this.reading();
    }

     private void reading() {
         mapToRead = new LinkedHashMap<>();
         try {
             FileInputStream fis = new FileInputStream("data2.ser");
             ObjectInputStream ois = new ObjectInputStream(fis);

             mapToRead = (LinkedHashMap<Pair<Integer, Double>, Map<Integer, Double>>) ois.readObject();

             ois.close();
             fis.close();
         } catch (IOException ioe) {
             ioe.printStackTrace();
             return;
         } catch (ClassNotFoundException c) {
             c.printStackTrace();
         }
     }
}


