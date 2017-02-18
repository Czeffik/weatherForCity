import java.io.IOException;

public class WorkingProgram {
    private long actualTime;
    private long time;

    public WorkingProgram() throws InterruptedException, IOException {
        new WritingMathToFile();
        actualTime = (System.currentTimeMillis()/1000);
        time = 1487440800;
        this.working();

    }
    private void working() throws InterruptedException {

        if (actualTime == time){
            new WritingMathToFile();
            time+=10800;
            Thread.sleep(((time-actualTime)*1000));
            actualTime = (System.currentTimeMillis()/1000);
            this.working();
        }
        else{
            actualTime = (System.currentTimeMillis()/1000);
            Thread.sleep(1000);
            this.working();
        }
    }
}
