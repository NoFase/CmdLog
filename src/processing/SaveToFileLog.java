package processing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class SaveToFileLog {

    private EntryInLog entryInLog;
    private BufferedWriter bw;

    public SaveToFileLog(EntryInLog entryInLog, int count, String nameServer) throws IOException {
        this.entryInLog = entryInLog;

        bw = new BufferedWriter(new FileWriter(Paths.get("").toAbsolutePath().toString() +  "/fileLog_" + nameServer + ".txt", true));
        StringBuilder sb = new StringBuilder();
        sb.append(count + "\t").append(entryInLog.getDate() + "\t").append(entryInLog.getTime() + "\t").
                append(entryInLog.getLogin() + "\t\t").append(entryInLog.getIpAddress() + ":\t").
                append(entryInLog.getDetailInfo());
        bw.write(sb.toString() + "\r\n");
        bw.flush();
    }
}
