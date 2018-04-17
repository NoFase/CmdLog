import debuging.CollectorLogs;
import processing.ListOfServers;
import processing.TimeSetting;
import visual.TrayIconMy;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new TrayIconMy();
        new ListOfServers();
        CollectorLogs.debugging("program started");
        new TimeSetting();
    }
}
