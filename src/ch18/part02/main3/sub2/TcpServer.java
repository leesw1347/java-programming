package ch18.part02.main3.sub2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class TcpServer {
    public static void main(String[] args) {
        // 메인함수 - 테스트용
        new TcpServer().doServer();
    }

    /*
     접속 시 클라이언트의 쓰기작업과 읽기 작업 쓰레드 저장
        -> 서버 전체가 클라이언트에게 쓰기 작업할 때 필요함
     */
    private Map<Socket, Thread> sendThreadMap = new HashMap<>();

    private void doServer() {
        // 서버 프로그램 구동 및 서버정보 출력
        try {
            ServerSocket socket = new ServerSocket(12225, 512);
            System.out.println("서버시작");
            System.out.println(socket.getLocalSocketAddress()); // 서버IP:Port
            System.out.println(socket.getInetAddress()); // IP
            System.out.println(socket.getLocalPort()); // Port
            System.out.println("------");

            while (true) {
                // 서버 클라이언트 접속 응답대기
                final Socket accept = socket.accept();

                // 클라이언트 접속자 주소 정보
                InetAddress ia = accept.getInetAddress();
                System.out.println("\t [클라이언트 주소] = " + ia.getHostAddress());
                System.out.println("\t [클라이언트 이름] = " + ia.getHostName());

                // 송신 쓰레드 객체생성
                Thread sendThread = new ThreadSend(accept, "server"); // 쓰레드분리
                sendThreadMap.put(accept, sendThread); // 해당 쓰레드 저장
                sendThread.start();

                /*
                 수신 쓰레드 객체생성
                    - sendThreadMap 파라미터
                     서버로 들어오는 메세지를 모든 클라이언트에게 전송 목적
                     해당 쓰레드 accept는 제외함
                 */
                Thread receiveThread = new ThreadReceive(accept, "server", sendThreadMap);
                receiveThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}