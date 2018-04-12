package cerviceForTesting;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask {
    private static final long LONGDAYBYSECONDS = 86400000;

    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat form = new SimpleDateFormat("yyyy&MM&dd hh&mm");
        Date time = new Date();
        System.out.println(form.format(time));
        Date time2 = new Date(118, 04, 01, 12, 31);

        System.out.println(form.format(time2));

        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate);
        LocalDateTime ld = null;

             ld = localDate.plusDays(1);
            System.out.println(ld);

        Date d1 = Date.from(ld.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(form.format(d1) + " <<<<====" );

        System.out.println(form.format(time2.getTime() - LONGDAYBYSECONDS) + " <--------");

    }
}
