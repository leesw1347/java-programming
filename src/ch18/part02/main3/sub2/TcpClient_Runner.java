package ch18.part02.main3.sub2;

public class TcpClient_Runner {
    public static void main(String[] args) {
        IClientUser clientUser = new IClientUser() {
            @Override
            public void writeMessage(String readLine) {
                System.out.println(readLine.toString());
            }
        };
        TcpClient client = new TcpClient("major1", clientUser);
        client.connect();
    }
}
