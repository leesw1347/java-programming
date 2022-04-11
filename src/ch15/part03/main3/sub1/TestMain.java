package ch15.part03.main3.sub1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        // 절차 1. FileReader 객체생성
        FileReader fr = null;

        try {
            fr = new FileReader("D:\\IO\\io3.txt");

            // 절차2. 읽기작업
            while (true) {
                int read = fr.read(); // 1 char씩 읽기
                if (read == -1) { // 파일을 다 읽을 경우 -1을 반환
                    break;
                }
                System.out.print((char) read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 종료 작업
        try {
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
