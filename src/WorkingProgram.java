public class WorkingProgram {
    private long actualTime;
    private long time;

    public WorkingProgram(String city) {
        System.out.println("Program working...");
        new WritingMathToFile(city);
        actualTime = (System.currentTimeMillis()/1000);
        time = actualTime-(actualTime%3600)+3600;
        this.working(city);

    }
    private void working(String city){

        if (actualTime > time){
            new WritingMathToFile(city);
            time+=3600;
            try {
                Thread.sleep(((time-actualTime)*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            actualTime = (System.currentTimeMillis()/1000);
            this.working(city);
        }
        else{
            actualTime = (System.currentTimeMillis()/1000);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.working(city);
        }
    }
}
