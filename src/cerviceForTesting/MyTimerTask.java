package cerviceForTesting;

import java.text.SimpleDateFormat;
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



//        System.out.println(form.format(">>>> " + time2));

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.print("enter = > ");
                System.out.println(form.format(new Date()));
            }
        };

        timer.scheduleAtFixedRate(task, time2, 60000);
    }
}
