import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        ReadingUrl nowy = new ReadingUrl("http://api.openweathermap.org/data/2.5/weather?q=Oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a", "http://api.openweathermap.org/data/2.5/forecast?q=oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a" );
//        System.out.println(nowy.getMapMap());

//        WritingToFile nowy = new WritingToFile();
//        ReadingFromFile second = new ReadingFromFile();

        DoingMath nowy = new DoingMath();
        nowy.getDifferenceBetweenForecastAndActualTemp();

    }







//    private static String readAll(Reader rd) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        int cp;
//        while ((cp = rd.read()) != -1) {
//            sb.append((char) cp);
//        }
//        return sb.toString();}
//
//    public static JSONObject readJsonFromUrl(String link) throws IOException {
//        InputStream is = new URL(link).openStream();
//        try {
//            BufferedReader bufer = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//            String jsonText = readAll(bufer);
//            JSONObject json = new JSONObject(jsonText);
//            return json;
//        } finally {
//            is.close();
//        }
//    }
//    public static void main(String[] args) throws IOException {
//       JSONObject json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast?q=oswiecim,pol&APPID=71ad073f87383bd799851e6388bfcc8a");
////       System.out.println(json.toString());
//       System.out.println(json.get("list"));
////        System.out.println(json.get("temp"));

    }

