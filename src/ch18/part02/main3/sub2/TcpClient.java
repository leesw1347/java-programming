package ch18.part02.main3.sub2;

import java.io.IOException;
import java.net.Socket;

/**
 * TCP 통신을 위한 클라이언트용 클래스
 */
public class TcpClient {
    private Socket socket = null;
    private ThreadSend st = null;
    IClientUser clientUser = null;
    String name = null;

    /**
     * ClientUI 화면에서 "서버접속" 클릭 시 해당 생성자 함수 호출
     */
    public TcpClient(String name, IClientUser clientUser) {
        this.name = name;
        this.clientUser = clientUser;
    }

    /**
     * 클라이언트 접속 함수
     */
    public void connect() {
        // 클라이언트 소켓 생성
        try {
            while (true) {
                socket = new Socket("localhost", 12225);
                if (!socket.isConnected()) {
                    Thread.sleep(2000);
                    continue;
                } else {
                    break;
                }
            }

            // 쓰기 작업 쓰레드
            st = new ThreadSend(socket, name);
            System.out.println(socket);
            System.out.print("소켓연결완료 ? " + socket.isConnected());

            // 읽기 작업 쓰레드
            ThreadReceive rt = new ThreadReceive(socket, name, clientUser);
            rt.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 클라이언트 통신종료 함수
     */
    public void close() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * UI 객체 TcpClient 쓰기 작업
     * SendThread 쓰기 작업
     */
    public void setMessage(String msg) {
        System.out.println("st = " + st + " : " + msg);
        if (st != null) {
            st.sendMessage(msg);
        }
    }
}
