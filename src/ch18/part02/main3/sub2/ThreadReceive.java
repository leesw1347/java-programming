package ch18.part02.main3.sub2;

import javax.naming.ldap.SortKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ThreadReceive extends Thread {

    private Socket socket;
    private String owner;
    private Map<Socket, Thread> sendThreadMap;
    private IClientUser clientUser;

    public ThreadReceive(Socket accept, String server, Map<Socket, Thread> sendThreadMap) {
    }

    /**
     * 클라이언트가 읽기작업을 위해 사용하는 생성자함수
     * clientUser: 통신을 위해 들어오는 자료를 화면 UI에 쓰기작업하기 위한 객체
     */
    public ThreadReceive(Socket socket, String owner, IClientUser clientUser) {
        this.socket = socket;
        this.owner = owner;
        this.sendThreadMap = (Map<Socket, Thread>) clientUser;
    }

    /**
     * 쓰레드 실행함수
     */
    @Override
    public void run() {
//        super.run();
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), "EUC-KR")
            );

            System.out.println("서버 대기중");

            while (true) {
                String readLine = br.readLine();
                if (readLine == null) {
                    break;
                }
                System.out.println(owner + "\t: -> " + readLine);

                if ("server".equals(owner)) { // 서버의 경우 자신을 제한 모든 클라이언트에게 전송
                    if (sendThreadMap != null) {
                        // sendThreadMap에 담겨있는 모든 소켓에 쓰기 작업
                        Set<Socket> keySet = sendThreadMap.keySet();
                        for (Socket s : keySet) {
                            if (s instanceof Socket && s != null && !s.isClosed()) {
                                ThreadSend thread = (ThreadSend) sendThreadMap.get(s);
                                thread.sendMessage(readLine);
                            }
                        }
                    }
                }
                // 클라이언트의 경우 자신의 UI 창에 쓰기 작업을 한다
                else {
                    System.out.print("들어옴 " + readLine);
                    if (clientUser != null) {
                        clientUser.writeMessage(readLine);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
