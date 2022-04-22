package ch18.part02.main2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TcpClient {
    public static void main(String[] args) {
        new TcpClient().doClient();
    }

    private void doClient() {
        try {
            Socket socket = new Socket("localhost", 12225);
//            System.out.println(socket);

            // 통신을 위한 InputStream, OutputStream 객체 가져옴
            InputStream is = socket.getInputStream(); // 서버로부터의 데이터 수신 스트림
            OutputStream os = socket.getOutputStream(); // 서버로부터 데이터 송신 스트림

            // 클라이언트 수신 작업 쓰레드 분리 및 시작
            new Thread() {
                @Override
                public void run() {
                    // InputStream -> InputStreamReader -> BufferedReader 객체생성
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

                    // 서버로부터 자료 스신
                    while (true) {
                        // 서버가 송신한 자료를 수신한다
                        try {
                            String readLine = br.readLine();
                            if (readLine == null || readLine.equals("")) {
                                break;
                            }
                            print("[클라이언트화면]",
                                    readLine);
                        } catch (IOException e) {
                            e.printStackTrace();

                            // 수신에러 발생 시, 클라이언트 통신 소켓 종료
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }.start();

            // 클라이언트 송신작업 쓰레드 분리 및 시작
            new Thread() {
                @Override
                public void run() {
                    // OutputStream -> OutputStreamWriter -> BufferedWriter 객체생성
                    BufferedWriter bw
                            = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
                    while (true) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Date date = new Date(System.currentTimeMillis());
                        // 서버로 자료를 송신한다
                        try {
                            bw.write("[2] Client->ServerSokcet : " + date.toString() + "\r\n");
                            bw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();

                            // 송신에러 발생 시 클라이언트 통신소켓 종료
                            try {
                                if (socket != null) {
                                    socket.close();
                                }
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(String name, Object obj) {
        if (!name.equals("") && obj != null) {
            System.out.println(name + " " + obj.toString());
        }
    }
}