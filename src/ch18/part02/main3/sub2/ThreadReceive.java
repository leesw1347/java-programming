package ch18.part02.main3.sub2;

import java.net.Socket;
import java.util.Map;

public class ThreadReceive extends Thread {
    public ThreadReceive(Socket accept, String server, Map<Socket, Thread> sendThreadMap) {
    }

    public ThreadReceive(Socket socket, String name, IClientUser clientUser) {
    }
}
