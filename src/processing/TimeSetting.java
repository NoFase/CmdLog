package processing;

import network.ConnectorToServers;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimeSetting {
    public  ConnectorToServers connectorToServers;
    private final long LONGDAYBYSECONDS = 86400000;

    public TimeSetting() {

        MyDate time = new MyDate();
        Date startTime = time.setStartTime();

        System.out.println(time.setStartTime());
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    connectorToServers = new ConnectorToServers(new MyDate());
                    connectorToServers.connectToServer();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(new GregorianCalendar().getTime());
                    connectorToServers.disconnectFromServer();
                }
            };
        Timer timer =  new Timer();
        timer.schedule(timerTask, startTime, LONGDAYBYSECONDS);
    }
}
