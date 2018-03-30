package processing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFileLog {

    private EntryInLog entryInLog;
    BufferedWriter bw = new BufferedWriter(new FileWriter("c:/fileLog.txt", true));

    public SaveToFileLog(EntryInLog entryInLog, int count) throws IOException {
        this.entryInLog = entryInLog;
        StringBuilder sb = new StringBuilder();
        sb.append(count + "\t").append(entryInLog.getDate() + "\t").append(entryInLog.getTime() + "\t").
                append(entryInLog.getLogin() + "\t\t").append(entryInLog.getIpAddress() + ":\t").
                append(entryInLog.getDetailInfo());
        bw.write(sb.toString() + "\r\n");
        bw.flush();
    }

}
