import javafx.util.Pair;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class WritingToFile {
    public WritingToFile() throws IOException {
        this.writting();
    }
    private void writting() throws IOException {
        Pair<Pair<Integer, Double>, Map<Integer, Double>>pairToWrite = new ReadingUrl("http://api.openweathermap.org/data/2.5/weather?q=Oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a", "http://api.openweathermap.org/data/2.5/forecast?q=oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a").getPairPairMap();

        try
        {
            FileOutputStream fos = new FileOutputStream("data.ser", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pairToWrite.getKey());
            oos.writeObject(pairToWrite.getValue());
            oos.close();
            fos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
