package ch18.part03.main2.sub2;


import ch18.part02.main3.sub2.IClientUser;
import ch18.part02.main3.sub2.ThreadReceive;
import ch18.part02.main3.sub2.ThreadSend;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * UDP 구현과는 관련 없지만 TCP와 모두 호환되도록 구현하기 위해서 수정한다
 */
public class TcpClient extends AbstractClientSocket {
    // ClientController와 결합력을 낮추기 위해 AbstractClientSocket 사용
    private Socket socket = null;
    private ThreadSend st = null;

    /**
     * @param name
     * @param clientUser
     * @summary ClientUI 화면에서 "서버접속" 클릭 시 해당 생성자 함수 호출
     */
    public TcpClient(String name, IClientUser clientUser) {
        super(name, clientUser);
    }

    // UI 객체 TcpClient 쓰기 작업 -> SendThread 쓰기 작업
    @Override
    public void sendMessage(String msg) {
        System.out.println("st = " + st + " : " + msg);
        if (st != null) {
            st.sendMessage(msg);
        }
    }

    // 클라이언트 접속함수
    @Override
    public void connect() {
        try {
            // 클라이언트 소켓 생성
            socket = new Socket("localhost", 12225);

            // 쓰기 작업 쓰레드
            st = new ThreadSend(socket, name);
            st.start();

            // 읽기 작업 쓰레드
            ThreadReceive rt = new ThreadReceive(socket, name, clientUser);
            rt.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        // 클라이언트 통신종료 함수
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
