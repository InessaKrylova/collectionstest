import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1980);
        Date old = calendar.getTime();

        Date date = new Date(23645624L);
    }

    
}
