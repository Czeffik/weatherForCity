import java.io.*;
import java.util.Map;

public class WritingMathToFile {
    public WritingMathToFile() {
        this.writingToString();
        this.writingToObject();
    }
    private void writingToString(){
        Map<Integer, Map<Integer, Double>> mathDone = new MathDoing().getAllDifferences();
        try{
            FileWriter fileToWrite = new FileWriter("writtenMathData2.txt");
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
    private void writingToObject(){
        Map<Integer, Map<Integer, Double>> mathDone = new MathDoing().getAllDifferences();
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("writtenMathDataObject2.ser"));
            oos.writeObject(mathDone);
            oos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
