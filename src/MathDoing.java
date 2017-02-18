import javafx.util.Pair;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MathDoing {
    private Map<Integer, Map<Integer,Double>> allDifferences;

    public Map<Integer, Map<Integer, Double>> getAllDifferences() {
        return allDifferences;
    }

    public MathDoing(){
        this.mathing();
    }
    private void mathing(){
        Map<Pair<Integer, Double>, Map<Integer, Double>> mapToRead = new ReadingFromFile().getMapToRead();
        allDifferences = new LinkedHashMap<>();

        for (Pair keyMapToRead: mapToRead.keySet()) {
            int pairKey = (int) keyMapToRead.getKey();
            double pairValue = (double) keyMapToRead.getValue();
            Map<Integer, Double> differenceTimeAndTemperature = new TreeMap<>();

            for (Pair keyMapToRead2 : mapToRead.keySet()) {
                int pairKey2 = (int) keyMapToRead2.getKey();

                for (int mapKey : mapToRead.get(keyMapToRead2).keySet()) {
                    if(pairKey==mapKey){
                        int key = (pairKey2-pairKey)/3600;
                        double value = pairValue - mapToRead.get(keyMapToRead2).get(mapKey);
                        differenceTimeAndTemperature.put(key, value);
                    }
                }
            }
            if (differenceTimeAndTemperature.size() > 0) {
                allDifferences.put(pairKey, differenceTimeAndTemperature);
            }
        }
//        System.out.println(allDifferences);
    }
}
