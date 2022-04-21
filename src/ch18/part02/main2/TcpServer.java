package ch18.part02.main2;

import javax.swing.table.TableCellEditor;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.text.MessageFormat;
import java.util.Date;

public class TcpServer {

    // 메인함수 정의
    public static void main(String[] args) throws IOException {
        // TcpServer 객체생성 및 doServer() 함수 실행
        new TcpServer()
                .doServer();
    }

    private void doServer() throws IOException {
        /**
         * 서버소켓 객체생성
         */
        ServerSocket socket = new ServerSocket(12225);
        System.out.println("서버시작");
        System.out.println(socket.getLocalSocketAddress());
        System.out.println(socket.getInetAddress());
        System.out.println(socket.getLocalPort());
        System.out.println("---------------------------------");

        while (true) {
            // 무한루프를 이용한 응답대기
            // 클라이언트 수신을 대기한다 (blocking)
            final Socket accept = socket.accept();

            // 클라이언트 접속정보 조회
            synchronized (accept) {
                InetAddress inetAddress = accept.getInetAddress();
                System.out.println("클라이언트 접속");
                System.out.println("getHostAddress = " + inetAddress.getHostAddress());
                System.out.println("getHostName = " + inetAddress.getHostName());
            }

            // 통신을 위한 InputStream, OutputStream 객체를 가져옴
            InputStream is = accept.getInputStream();
            OutputStream os = accept.getOutputStream();

            // 서버 수신작업 쓰레드 분리 및 시작
            new Thread() {
                @Override
                public void run() {
//                    super.run();
                    // InputStream -> InputStreamReader -> BufferedReader 객체생성
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(is));
                    try {
                        // 자료수신
                        while (true) {
                            // 클라이언트가 송신한 자료를 수신한다
                            String readLine = br.readLine();
                            if (readLine == null || readLine.equals("")) {
                                break;
                            }
                            print("서버화면", readLine);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            // 서버 송신작업 쓰레드 분리 및 시작
            new Thread() {
                @Override
                public void run() {
                    /**
                     * OutputStream -> OutputStreamWriter -> BufferedWriter 객체생성
                     */
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                    try {
                        // 3초마다 시간 값을 전송, 반드시 보낼 때 \r\n을 붙일 것
                        while (true) {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Date date = new Date(System.currentTimeMillis());
                            // 클라이언트로 자료를 송신(Send) 한다
                            synchronized (socket) {
                                bw.write(MessageFormat.format("[1] SocketServer->Client : {0}\r\n", date.toString()));
                                bw.flush();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static void print(String name, Object obj) {
        System.out.println("obj가 instanceof가 뭐지 ? " + obj instanceof String);
        if (!name.equals("") && obj != null
                && obj instanceof String) {
            System.out.println("[" + name + "] " + obj.toString());
        }
    }
}
