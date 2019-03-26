import java.util.TimeZone;

public class StopWatch {

    public StopWatch() {
    }

    private long startTime;
    private long endTime;

    public  void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    /*public long getTime() {
        long millis = this.elapsed(TimeUnit.MILLISECONDS);
    }*/
}
