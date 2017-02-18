import java.io.IOException;

public class WorkingProgram {
    private Long actualTime;
    private long time;

    public WorkingProgram() throws InterruptedException, IOException {
        WritingMathToFile work = new WritingMathToFile();
        actualTime = (System.currentTimeMillis()/1000);
        time = 1487376000;
        this.working();

    }
    private void working() throws InterruptedException, IOException {

        if ((actualTime=actualTime-(actualTime%100)) == time){
            WritingMathToFile working = new WritingMathToFile();
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
