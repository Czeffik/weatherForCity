import javafx.util.Pair;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadingFromFile {
    private Map<Pair<Integer, Double>, Map<Integer, Double>> mapToRead=new LinkedHashMap<>();;
    private static int id = 0;

    public Map<Pair<Integer, Double>, Map<Integer, Double>> getMapToRead() {
        return mapToRead;
    }

    public ReadingFromFile() throws IOException {
        WritingToFile nowy = new WritingToFile();
        this.reading();
    }

     private void reading(){
            try
            {
                FileInputStream fis = new FileInputStream("data.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
//                FileReader czytak = new FileReader("data.ser");
//                BufferedReader br = new BufferedReader(czytak);
//                String line;
//                System.out.println(br.toString());
//                while((line=br.readLine())!=null) {
                System.out.println(ois.read());
                int line;
                while((line = ois.read())==-1) {
                    mapToRead.put((Pair<Integer, Double>) ois.readObject(), (LinkedHashMap<Integer, Double>) ois.readObject());
                }
                ois.close();
                fis.close();
            }catch(IOException ioe)
            {
                ioe.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                c.printStackTrace();
            }
            System.out.println(mapToRead);
            }
        }


