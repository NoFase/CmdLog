package processing;


import java.io.IOException;

public class EntryInLog {
    private String login, ipAddress, commandCode, date, time, status, errorCode, detailInfo;
//    BufferedWriter bw = new BufferedWriter(new FileWriter("c:/java/outputLog.txt"));

    public void setLogin(String login) {
        this.login = login;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

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


    public EntryInLog() {
    }

    public EntryInLog(String login, String ipAddress, String commandCode, String date, String time, String status, String errorCode) {
        this.login = login;
        this.ipAddress = ipAddress;
        this.commandCode = commandCode;
        this.date = date;
        this.time = time;
        this.status = status;
        this.errorCode = errorCode;
    }

    public EntryInLog(String login, String ipAddress, String commandCode, String date, String time, String status, String errorCode, String detailInfo) throws IOException {
        this.login = login;
        this.ipAddress = ipAddress;
        this.commandCode = commandCode;
        this.date = date;
        this.time = time;
        this.status = status;
        this.errorCode = errorCode;
        this.detailInfo = detailInfo;
    }
}
