package processing;

import java.io.IOException;

public class MsgAnalyser {

    private String value;
    private String login, ipAddress, commandCode, date, time, status, errorCode, detailInfo;

    public String getLogin() {
        return login;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCommandCode() {
        return commandCode;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public MsgAnalyser(String value) {
        this.value = value;
    }
    public boolean firstAnalysing(){
        if (value.contains("logged in successfully")) return true;
        return false;
    }

    public void secondAnalysing() throws IOException {
//            ReaderFromFile readerFromFile = new ReaderFromFile();
//        System.out.println("Sending to analysing: " + value);
//        if (value.contains("BAM")) entryInLog = new EntryInLog();
//            readerFromFile.lineDefendering(value);
//        System.out.println(readerFromFile.entryInLogs.size());

        String[] lines = value.split("\\s+");
//        System.out.println("--->" + line);
        if (lines.length > 1) // all lines starting wist space, and first element in always == " "
        {
            if (lines[1].equals("BAM"))
            {
                login = lines[2];
                ipAddress = lines[3];
                commandCode = lines[4];
                date = lines[5];
                time = lines[6];
                status = lines[7];
                errorCode = lines[8];
//                System.out.println(login);
            }
            else if (lines[1].equals("Detailed"))
            {
//                System.out.println(line);
//                if (!line.contains("TRF") || !login.equals("AutoTask"))
                if (!value.contains("TRF"))
                {
                    if (!value.contains("ALMLOG")) {
                        StringBuilder sb = new StringBuilder(value);
                        detailInfo = sb.delete(0, 28).toString();// deleting "Detail operation command:"
                    }
                }
            }
        }
    }
}
