import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadingFromFile {
    private Map<Pair<Integer, Double>, Map<Integer, Double>> mapToRead=null;

    public Map<Pair<Integer, Double>, Map<Integer, Double>> getMapToRead() {
        return mapToRead;
    }

    public ReadingFromFile() {
        this.reading();
    }

     private void reading(){
            try
            {
                FileInputStream fis = new FileInputStream("data.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                mapToRead = (LinkedHashMap) ois.readObject();
                ois.close();
                fis.close();
            }catch(IOException ioe)
            {
                ioe.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                c.printStackTrace();
            }
//            System.out.println(mapToRead);
            }
        }


