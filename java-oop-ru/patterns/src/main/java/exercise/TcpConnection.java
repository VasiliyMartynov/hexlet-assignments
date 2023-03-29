package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    String ip;
    int port;

    Connection connection;

    TcpConnection(String ipAddress, int portNumber) {
        this.ip = ipAddress;
        this.port = portNumber;
        this.connection = new Disconnected(this);
    }

    public String getCurrentState(){
        return this.connection.getCurrentState();
    };

    public void setState(Connection connection) {
        this.connection = connection;
    }

    void connect(){
        this.connection.connect();

    };
    void disconnect(){
        this.connection.disconnect();
    };
    public void write(String data){
        this.connection.write(data);

    };

}
// END
