package ch18.part03.main2.sub2;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class UdpServer {
    public static void main(String[] args) {
        new UdpServer().doServer();
    }

    private void doServer() {
        try {
            // Datagram 서버소켓 생성 - 포트 필요
            DatagramSocket socket = new DatagramSocket(12345);

            // 서버정보 출력
            System.out.println("서버시작");
            System.out.println(socket.getLocalSocketAddress());
            System.out.println(socket.getInetAddress());
            System.out.println(socket.getLocalPort());
            System.out.println("----");

            // 중복을 고려하여 접속자를 저장
            Set<SocketAddress> list = new HashSet<>();

            // 수신작업 쓰레드 객체생성 및 실행 시작
            new Thread() {
                @Override
                public void run() {
                    // super.run();
                    byte[] by = new byte[65535];

                    // 소켓으로 들어오는 자료를 받기위한 패킷 생성
                    DatagramPacket packet = new DatagramPacket(by, by.length);

                    while (true) {
                        try {
                            // 서버 소켓으로 들어오는 자료를 수신하며, 수신할 때까지 대기
                            System.out.println("클라이언트가 접속하기까지를 기다려볼게요~~");
                            socket.receive(packet); // receive 함수에서는 DatagramPacket를 받아서 packet에 정의한 buf(by)에 데이터를 수신한다

                            // 수신된 외부정보 조회 및 출력
                            String msg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);

                            // 신규진입의 경우 클라이언트 정보저장
                            if (msg.startsWith("connect://")) {
                                InetAddress ia = packet.getAddress();
                                SocketAddress socketAddress = packet.getSocketAddress();
                                System.out.println("주소: " + ia.getHostAddress());
                                System.out.println("이름: " + ia.getHostName());
                                System.out.println("포트: " + packet.getPort());
                                System.out.println("내용: " + msg);
                                // 해당 클라이언트 소켓정보 저장
                                list.add(packet.getSocketAddress());
                                msg = msg.replace("connect://", "");
                                msg += "님이 로그인하였습니다";
                            }

                            // 모든 클라이언트에게 들어오는 자료 전파
                            for (SocketAddress s : list) {
                                if (s.equals(packet.getSocketAddress())) {
                                    continue;
                                }
                                try {
                                    // 외부(서버)로 전송할 패킷 전송 - 목적지설정 필요
                                    DatagramPacket packet1 = new DatagramPacket(msg.getBytes(), msg.getBytes().length, s);
                                    // 외부 서버로 전송
                                    socket.send(packet1);

                                } catch (UnknownHostException e) {
                                    list.remove(s); // 해당 호스트가 존재하지 않을 경우, 송신대상에서 제외한다
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
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