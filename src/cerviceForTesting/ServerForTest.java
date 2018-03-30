package cerviceForTesting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class ServerForTest {


    static BufferedWriter bw;

    public static void main(String[] args)  throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server Started:");
//        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8")));
            while (true) {
                String s = br.readLine();
                if (s != null || s != "") {
                    checking(s);
//                bw.flush();
                }
            }
//        }
    }

    private static void checking(String s) throws IOException {
        if (s != null) {
            if (s.contains("LGI:op=")) readingFromFile(s, "d:/JavaProjects/CmdLog/logining.txt");
            else if (s.contains("CMDLOG"))
                readingFromFile(s, "d:/JavaProjects/CmdLog/Maintenance_2018-03-05-10-07-41.txt");
        }
    }

    private static void readingFromFile(String s, String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
//            System.out.print(line + "\r\n");
            bw.write(line + "\r\n");
            bw.flush();
        }
        System.out.println(("file finished"));
    }
}
