import javafx.util.Pair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class WritingToFile {
    private Map<Pair<Integer, Double>, Map<Integer, Double>> mapToWrite=new LinkedHashMap<>();
    public WritingToFile(){
        if(new File("data2.ser").exists()){
        mapToWrite = new ReadingFromFile().getMapToRead();
        }
        this.creatingMap();
        this.writting();
    }
    private void creatingMap(){
        Pair<Pair<Integer, Double>, Map<Integer, Double>>pairToWrite = new ReadingUrl("http://api.openweathermap.org/data/2.5/weather?q=Oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a", "http://api.openweathermap.org/data/2.5/forecast?q=oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a").getPairPairMap();
        mapToWrite.put(pairToWrite.getKey(),pairToWrite.getValue());
    }
    private void writting(){

        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data2.ser"));
            oos.writeObject(mapToWrite);
            oos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
