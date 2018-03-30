import network.ConnectorToServers;
import processing.TimeSetting;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        String line;
//        BufferedReader reader = new BufferedReader(new FileReader("D:/TMP/Maintenance_2018-03-05-10-07-41.txt"));
//        ReaderFromFile log = new ReaderFromFile();
//        while (( line = reader.readLine() ) != null){
//            log.lineDefendering(line);
//        }
//
//        for (int i = 0; i < log.entryInLogs.size(); i++) {
//            System.out.println(log.entryInLogs.get(i).getLogin() + " " + log.entryInLogs.get(i).getIpAddress() + " " +
//                    log.entryInLogs.get(i).getDate() + " " +
//                    log.entryInLogs.get(i).getTime() + " " + log.entryInLogs.get(i).getStatus() + " " +
//                    log.entryInLogs.get(i).getErrorCode() + " " +log.entryInLogs.get(i).getDetailInfo() + " " );
//        }
//        ConnectorToServers connectorToServers = new ConnectorToServers();
//        connectorToServers.connectToServer();

        new TimeSetting();

    }
}
