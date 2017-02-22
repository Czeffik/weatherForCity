//Creating link for API
public class Link {
    private String city;
    private String presentLink= "http://api.openweathermap.org/data/2.5/weather?q="+city+",pol&APPID=71ad073f87383bd799851e6388bfcc8a";
    private String futureLink= "http://api.openweathermap.org/data/2.5/forecast?q="+city+",pol&APPID=71ad073f87383bd799851e6388bfcc8a";

    public String getPresentLink() {
        return presentLink;
    }

    public String getFutureLink() {
        return futureLink;
    }

    public Link(String city){
        this.city = city;
    }
}
