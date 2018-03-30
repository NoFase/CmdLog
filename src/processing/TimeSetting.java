package processing;

import network.ConnectorToServers;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimeSetting {
    public  ConnectorToServers connectorToServers;

    public TimeSetting() {

            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    connectorToServers = new ConnectorToServers();
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
        timer.schedule(timerTask, 0, 10000);

    }
}
