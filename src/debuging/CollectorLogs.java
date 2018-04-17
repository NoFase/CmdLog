package debuging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class CollectorLogs {
    private static BufferedWriter bw;
    private LocalDateTime time;

    public CollectorLogs() throws IOException {
        bw = new BufferedWriter(new FileWriter(Paths.get("").toAbsolutePath().toString() + "/Debugs/debug.log"));
    }

    public static void debugging(String lineDebug) throws IOException {
        String line = LocalDateTime.now() + ": " + lineDebug + "\n\r";
        bw.write(line);
        bw.flush();
    }
}
