package network;

import processing.EntryInLog;
import processing.MsgAnalyser;
import processing.MyDate;
import processing.SaveToFileLog;

import java.io.IOException;
import java.util.Map;

public class ConnectorToServers extends Thread implements TCPConnectionListener {

    public static TCPConnection connection;
    private MyDate time;
    private Map.Entry<String,String> server;
    private EntryInLog entryInLog; // creating class with all parameters from line session enters

    //    private final long LONGDAYBYSECONDS = 120000;
    private final long LONGDAYBYSECONDS = 86400000;
    private int PORT = 6000;
    private int count = 0; // only for numbering lines to outline

    private String loginCommand = "LGI:op=\"smednyh\", PWD =\"SoftX3000\";";
    private String IP_ADDR;
//    String IP_ADDR = "127.0.0.1";
//    String IP_ADDR = "127.0.0.1";

    public ConnectorToServers(MyDate time, Map.Entry<String, String> server) {
        this.time = time;
        this.server = server;
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        System.out.println("Connected!");
        connection.sendString(loginCommand);
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) throws IOException {
//        Receiving something from server
        MsgAnalyser analyser = new MsgAnalyser(value);
        if (analyser.firstAnalysing()) {// checking for entering command into the server (need send command or no)
            connection.sendString(creatingCommand());
//            System.out.println("Sending to server command: " + command);
        }
        else analyser.secondAnalysing(); //analyse input line
        if (analyser.getLogin() != null) {//analyse first line, if this first input that need initialisate class EntryInLog
            entryInLog = new EntryInLog(analyser.getLogin(), analyser.getIpAddress(), analyser.getCommandCode(),
                    analyser.getDate(), analyser.getTime(), analyser.getStatus(), analyser.getErrorCode());
        } else if (analyser.getDetailInfo() != null) {// if the second line need set detail info in EntryInLog
            entryInLog.setDetailInfo(analyser.getDetailInfo());
            if (filter()) {
                new SaveToFileLog(entryInLog, count, server.getValue()); // to save in fileLog
                count++;
            }
        }
//        if (entryInLog != null) System.out.println(entryInLog.getLogin() + "<--------->" + entryInLog.getDetailInfo());
    }

    private boolean filter() {// filtering not needed items
        if (entryInLog.getLogin().equals("AutoTask")) return false;
        return true;
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        System.out.println("Connection close from server: " + connection.getSocket());
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("Something went wrong!!!\r\n" + e);
    }


    public void run() {
        try {
            IP_ADDR = server.getKey();
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            System.out.println("Connection exception: " + e);
        }
    }

    @Override
    public void interrupt() {
        connection.disconnect();
        super.interrupt();
    }

//    public void disconnectFromServer(){
//        connection.disconnect();
//    }

    private String creatingCommand (){
        return new StringBuilder().append("LST CMDLOG: ST=").append(time.dateForCommand(LONGDAYBYSECONDS)).append("&01&00&00, ET=")
                .append(time.dateForCommand(0)).append("&01&00&00, QM=ALL;").toString();
    }
}
