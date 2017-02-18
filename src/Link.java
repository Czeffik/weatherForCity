
public class Link {

    private String presentLink;
    private String futureLink;
    private String city;

    public String getPresentLink() {
        return presentLink;
    }

    public String getFutureLink() {
        return futureLink;
    }

    public String getCity() {
        return city;
    }

    public Link(String city){
        this.city = city;
        presentLink = "http://api.openweathermap.org/data/2.5/weather?q="+city+",pol&APPID=71ad073f87383bd799851e6388bfcc8a";
        futureLink = "http://api.openweathermap.org/data/2.5/forecast?q="+city+",pol&APPID=71ad073f87383bd799851e6388bfcc8a";
    }

}
