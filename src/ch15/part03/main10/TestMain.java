package ch15.part03.main10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {

        // ByteArrayOutputStream baos 객체생성
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // ByteArrayInputStream bais 객체생성
        ByteArrayInputStream bais = new ByteArrayInputStream("abcdefg1234567가나다라마바사".getBytes());
        byte[] by = new byte[10];
        try {
            while (true) {
                // ByteArrayInputStream 읽기작업
                int read = bais.read(by);
                if (read == -1) {
                    break;
                }

                // ByteArrayOutputStream 쓰기 작업
                baos.write(by, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ByteArrayInputStream, ByteArrayOutputStream 작업종료
        try {
            bais.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 결과 자료를 콘솔 화면에 나타내기
        String msg = baos.toString();
        System.out.println(msg);
    }
}
