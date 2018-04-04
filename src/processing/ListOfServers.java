package processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.nio.file.Paths;

public class ListOfServers {
    private static HashMap<String, String> servers;
    private BufferedReader br;

    public static HashMap<String, String> getServers() {
        return servers;
    }

    public ListOfServers() throws IOException {
//      open file in currently derictory with list of servers
        br = new BufferedReader(new FileReader(Paths.get("").toAbsolutePath().toString() + "/serversList.txt"));
//        initialisation HashMap
        servers = new HashMap<>();
        while (br.ready()){// read lines from the file
//          HashMap filling the data
            String[] line = br.readLine().split("\\s+");
            servers.put(line[0].trim(), line[1].trim().toUpperCase());
        }
        br.close();
    }
}
