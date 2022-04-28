package ch18.part03.main2.sub2;


import ch18.part02.main3.sub2.IClientUser;

import java.io.IOException;
import java.net.*;

// ClientController 결합력을 낮추기 위해 AbstractClientSocket 사용
public class UdpClient extends AbstractClientSocket {
    DatagramSocket socket = null;
    DatagramPacket datagramPacket = null;

    // 추상클래스에서 정의한 생성자 함수 사용
    public UdpClient(String name, IClientUser clientUser) {
        super(name, clientUser);
    }

    @Override
    public void sendMessage(String msg) {
        try {
            // 외부(서버)로 전송할 패킷생성 - 목적지정보 필요
            // localhost:12345로 msg 데이터를 전송한다
            DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("localhost"), 12345);
            System.out.println(datagramPacket + " : " + socket);

            // 외부(서버)로 자료전송
            socket.send(datagramPacket);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect() {
        try {
            // 클라이언트 소켓 생성
            socket = new DatagramSocket();
            System.out.println("socket = " + socket);

            // 최초 채팅이름을 서버로 전송
            sendMessage("connect://" + name);

            new Thread() {
                @Override
                public void run() {
                    byte[] by = new byte[65535];

                    // 수신을 위한 패킷 생성
                    DatagramPacket datagramPacket = new DatagramPacket(by, by.length);
                    while (true) {
                        try {
                            System.out.println("data = " + datagramPacket);
                            // 소켓으로 들어오는 자료수신하며 수신할 때까지 대기
                            socket.receive(datagramPacket);

                            // datagramPacket에는 socket으로부터 들어오는 패킷을 받는 준비를 한다
                            // clientUser로 자료를 송신
                            byte[] data = datagramPacket.getData();
                            // clientUser로 자료를 송신
                            clientUser.writeMessage(new String(data, 0, datagramPacket.getLength()));

                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            }.start();

        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() {
        if (socket.isConnected()) {
            socket.close();
        }
    }
}