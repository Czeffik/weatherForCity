import javafx.util.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadingUrl{
    private Map<Integer, Double> futureMap;
    private Pair<Integer, Double> presentPair;
    private Pair<Pair<Integer, Double>, Map<Integer, Double>> pairPairMap;

    public Pair<Pair<Integer, Double>, Map<Integer, Double>> getPairPairMap() {
        return pairPairMap;
    }

    public ReadingUrl(String linkPresent, String linkFuture){
        this.readingFuture(linkFuture);
        this.readingPresent(linkPresent);
        this.doPair();
    }

    private String stringBuilder(String link){
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        try {
            is = new URL(link).openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            int line;
            while ((line=br.read())!=-1){
                sb.append((char)line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    private void readingFuture(String linkFuture){
        futureMap = new LinkedHashMap<>();
        String text = this.stringBuilder(linkFuture);
        JSONObject json = new JSONObject(text);
        JSONArray jsonArray = new JSONArray(json.get("list").toString());
        int i=0;
        while(i<jsonArray.length()) {
            JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
            futureMap.put((int)jsonObject.get("dt"), Double.parseDouble(String.valueOf(new JSONObject(jsonObject.get("main").toString()).get("temp"))));
            i++;
        }
    }
    private void readingPresent(String linkPresent){
        String text = this.stringBuilder(linkPresent);
        JSONObject json = new JSONObject(text);
        presentPair = new Pair<>(((int)json.get("dt")-((int)json.get("dt")%3600)), (double) new JSONObject(json.get("main").toString()).get("temp"));
    }
    private void doPair (){
        pairPairMap = new Pair<>(presentPair, futureMap);
    }
}
