package ch18.part03.main2.sub2;

import ch18.part02.main3.sub2.IClientUser;

public class ClientController implements IClientUser {
    public static void main(String[] args) {
        AbstractClientSocket clientSocket = null;
        clientSocket = new UdpClient("swoo1015", null);
        clientSocket.connect();
        clientSocket.close();
    }

    @Override
    public void writeMessage(String readLine) {

    }
}
