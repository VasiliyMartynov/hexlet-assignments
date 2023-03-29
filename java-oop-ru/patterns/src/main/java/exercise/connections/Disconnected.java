package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection{
    TcpConnection tcpConnection;
    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        TcpConnection c = this.tcpConnection;
        c.setState(new Connected(c));
    }

    @Override
    public void disconnect() {
        if (this.getCurrentState().equals("disconnected")) {
            System.out.println("Error");
        }
        System.out.println("disconnected");

    }

    @Override
    public void write(String data) {
        System.out.println("Error");
    }
}
// END
