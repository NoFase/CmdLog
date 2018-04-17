package network;

import java.io.IOException;

public interface TCPConnectionListener {
    void onConnectionReady(TCPConnection tcpConnection) throws IOException;
    void onReceiveString(TCPConnection tcpConnection, String value) throws IOException;
    void onDisconnect(TCPConnection tcpConnection) throws IOException;
    void onException(TCPConnection tcpConnection, Exception e);
}
