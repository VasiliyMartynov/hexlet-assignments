package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection{
    TcpConnection tcpConnection;
    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }
    @Override
    public void connect() {
        if (this.getCurrentState().equals("connected")) {
            System.out.println("Error");
        }
        System.out.println("connected");
    }

    @Override
    public void disconnect() {
        TcpConnection c = this.tcpConnection;
        c.setState(new Disconnected(c));
    }

    @Override
    public void write(String data) {
        System.out.println("Writed data " + data);
    }
}
// END
