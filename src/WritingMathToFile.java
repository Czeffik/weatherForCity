import java.io.*;
import java.util.Map;

public class WritingMathToFile {
    public WritingMathToFile(String city) {
        Link link = new Link(city);
        new WritingToFile(link.getPresentLink(),link.getFutureLink(),city);
        this.writingToString(city);
        this.writingToObject(city);
    }
    private void writingToString(String city){
        Map<Integer, Map<Integer, Double>> mathDone = new MathDoing(city).getAllDifferences();
        try{
            FileWriter fileToWrite = new FileWriter(city+"WrittenMathData2.txt");
            BufferedWriter out = new BufferedWriter(fileToWrite);

            for(int mathDoneKey: mathDone.keySet()){
                java.util.Date time = new java.util.Date((long)mathDoneKey*1000);
                out.write(time.toString()+" results: \n");
                for(int mathResultsKey: mathDone.get(mathDoneKey).keySet()){

                    out.write(mathResultsKey +" hour forecast : difference between temperature: " + mathDone.get(mathDoneKey).get(mathResultsKey)+" |");
                }
                out.write("\n");
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writingToObject(String city){
        Map<Integer, Map<Integer, Double>> mathDone = new MathDoing(city).getAllDifferences();
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(city+"WrittenMathDataObject2.ser"));
            oos.writeObject(mathDone);
            oos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
