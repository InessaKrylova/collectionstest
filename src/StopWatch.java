
public class StopWatch {

    private long startTime;
    private long endTime;

    public  void start() {
        this.startTime = System.nanoTime();
    }

    public void end() {
        this.endTime = System.nanoTime();
    }

    public void printT(String collection) {
        long nanoseconds = endTime - startTime;
        System.out.println("Time for "+collection+": "+nanoseconds+" nanoseconds");
        /*long milliseconds = endTime - startTime;
        int seconds = (int) (milliseconds / 1000) % 60 ;
        System.out.println(seconds);
        System.out.println(milliseconds);*/
    }
}
