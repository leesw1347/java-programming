package ch15.part02.main2.sub1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;

public class TestMain {
    public static void main(String[] args) {
        // 절차1. FileInputStream 객체생성
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\IO\\io.txt");
            System.out.println(MessageFormat.format("fis 객체는 {0}", fis));

            // 절차2. 읽기 작업
            while (true) {
                int read = fis.read(); // 1byte씩 읽기
                if (read == -1) {
                    break; // 파일을 다 읽을 경우 -1을 반환
                }
                System.out.print((char) read); // 콘솔화면에 읽은 내용을 나타내기
            }

            if (fis != null) {
                fis.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}