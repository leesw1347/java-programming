package ch18.part03.main1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.sql.Struct;
import java.text.MessageFormat;
import java.util.Date;

public class UdpServer {
    public static void main(String[] args) {
        /**
         * 메인 함수 정의
         * UdpServer 객체 생성 및 doServer() 함수 실행
         */
        new UdpServer().doServer();
    }

    /**
     * doServer 함수 정의
     * 서버 소켓 생성
     * 무한 루프를 이용한 응답 대기
     * 클라이언트 접속 정보 조회
     * 서버 수신 작업 쓰레드 분리 및 시작
     * InputStream -> InputStreamReader -> BufferedReader 객체생성
     * 자료 수신
     * 서버 송신 작업 쓰레드 분리 및 시작
     * OutputStream -> OutputStreamWriter -> BufferredWriter 객체생성
     * 3초마다 시간값을 전송 -> 반드시 보낼 때 \r\n을 붙힐 것
     */
    private void doServer() {
        try {
            // 서버의 포트를 12345로 지정함
            DatagramSocket ds = new DatagramSocket(12345);

            // 수신 작업 쓰레드 객체생성 및 실행시작
            new Thread() {
                @Override
                public void run() {
                    byte[] by = new byte[0xffff];

                    // 자료수신을 위한 패킷생성
                    DatagramPacket dp = new DatagramPacket(by, by.length);
                    while (true) {
                        try {
                            // 소켓으로 들어오는 자료수신하며 수신할 때까지 대기
                            ds.receive(dp); // byte[] 배열에 수신한 데이터를 가져온다
                            System.out.println("UDP 소켓서버로 접속한 유저 확인");
                            System.out.println(MessageFormat.format("수신한 데이터의 길이 {0}", by.length));

                            // 외부로 전송할 자료구성
                            String data = new String(dp.getData(), 0, dp.getLength());
                            Date date = new Date(System.currentTimeMillis());
                            String msg = MessageFormat.format("{0}\t{1}", data, date);

                            // 외부로 전송할 패킷생성 - 목적지정보 필요
                            DatagramPacket dp2 = new DatagramPacket(
                                    msg.getBytes(),
                                    msg.getBytes().length,
                                    dp.getSocketAddress());

                            // 외부로 자료 전송
                            ds.send(dp2);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}