package cerviceForTesting;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat form = new SimpleDateFormat("yyyy&MM&dd hh&mm");
        Date time = new Date();
        System.out.println(form.format(time));
        Date time2 = new Date(118, 03, 03, 12, 31);

        System.out.println(form.format(time2));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate ld = null;

             ld = localDate.plusDays(1);
            System.out.println(ld);

        Date d1 = java.sql.Date.valueOf(ld);
        System.out.println(form.format(d1) + " <<<<====" );

    }
}
