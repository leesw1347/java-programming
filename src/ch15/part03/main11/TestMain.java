package ch15.part03.main11;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        // CharArrayWriter caos 객체생성
        CharArrayWriter caos = new CharArrayWriter();

        // CharArrayReader cais 객체생성
        CharArrayReader cais =
                new CharArrayReader(
                        "abcdefg1234567가나다라마바사".toCharArray()
                );
        char[] ch = new char[10];
        System.out.println(cais);

        try {
            while (true) {
                // CharArrayReader 읽기작업
                int read = cais.read(ch);
                if (read == -1) {
                    break;
                }

                // CharArrayWriter 쓰기작업
                caos.write(ch, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CharArrayReader, CharArrayWriter 작업 종료
        cais.close();
        caos.close();

        // 결과 자료를 콘솔화면에 나타내기
        String msg = caos.toString();
        System.out.println(msg);
    }
}