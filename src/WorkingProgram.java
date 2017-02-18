import java.io.IOException;

public class WorkingProgram {
    private long actualTime;
    private long time;

    public WorkingProgram(String city) throws InterruptedException, IOException {
        new WritingMathToFile(city);
        actualTime = (System.currentTimeMillis()/1000);
        time = actualTime-(actualTime%3600)+3600;
        this.working(city);

    }
    private void working(String city) throws InterruptedException {

        if (actualTime > time){
            new WritingMathToFile(city);
            time+=3600;
            Thread.sleep(((time-actualTime)*1000));
            actualTime = (System.currentTimeMillis()/1000);
            this.working(city);
        }
        else{
            actualTime = (System.currentTimeMillis()/1000);
            Thread.sleep(10000);
            this.working(city);
        }
    }
}
