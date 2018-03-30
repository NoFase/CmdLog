package cerviceForTesting;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask {
    public static void main(String[] args) throws InterruptedException {


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new GregorianCalendar().getTime());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        timer.schedule(task,0, 10000);
    }
}
