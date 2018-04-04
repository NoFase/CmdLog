package processing;

import network.ConnectorToServers;

import java.util.*;

public class TimeSetting {
    public  Thread connectorToServers;
    private final long LONGDAYBYSECONDS = 86400000;

    public TimeSetting() {

        MyDate time = new MyDate();
        Date startTime = time.setStartTime();

        System.out.println(time.setStartTime());
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {

                    for (HashMap.Entry<String,String> server : ListOfServers.getServers().entrySet()) {
                        connectorToServers = new ConnectorToServers(new MyDate(), server);
                        connectorToServers.run();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                    System.out.println(new GregorianCalendar().getTime());
                        connectorToServers.interrupt();
                    }
                }
            };
        Timer timer =  new Timer();
        timer.schedule(timerTask, startTime, LONGDAYBYSECONDS);
    }
}
