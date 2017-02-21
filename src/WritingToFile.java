import javafx.util.Pair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class WritingToFile {
    private Map<Pair<Integer, Double>, Map<Integer, Double>> mapToWrite=new LinkedHashMap<>();

    public WritingToFile(String linkPresent, String linkFuture, String city){
        if(new File(city+"Data2.ser").exists()){
            mapToWrite = new ReadingFromFile(city).getMapToRead();
            for(Pair mapToWriteKey:mapToWrite.keySet()){
                long actualTime = System.currentTimeMillis()/1000;
                //Deleting data older than oen month:
                if(actualTime - (long)mapToWriteKey.getKey()>2592000){
                    mapToWrite.remove(mapToWriteKey);
                }
            }
        }
        this.creatingMap(linkPresent, linkFuture);
        this.writting(city);
    }
    private void creatingMap(String linkPresent, String linkFuture){
        Pair<Pair<Integer, Double>, Map<Integer, Double>>pairToWrite = new ReadingUrl(linkPresent, linkFuture).getPairPairMap();
        mapToWrite.put(pairToWrite.getKey(),pairToWrite.getValue());
    }
    private void writting(String city){

        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(city+"Data2.ser"));
            oos.writeObject(mapToWrite);
            oos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
