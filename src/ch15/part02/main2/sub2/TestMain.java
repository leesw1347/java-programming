package ch15.part02.main2.sub2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        // FileInputStream 객체생성
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\IO\\io2.txt");

            // byte 배열 객체생성 및 byte 배열을 이용하여 읽기
            byte[] by = new byte[10];
            while (true) {
                // fis FileInputStream으로부터 by length만큼 읽어들인다
                int read = fis.read(by); // 1byte씩 읽기
                if (read == -1) {
                    break; // 파일을 다 읽을경우 -1을 반환
                }

                /**
                 *b y의 값을 문자로 변환하기
                 *  - 현재 자바에서 윈도우 시스템의 기본 인코딩은 MS949를 사용함
                 */
                // offset(0) : 첫 번째 자료, read(fis.read()에서 읽어들인 바이트배열 사이즈)
                String msg = new String(by, 0, read); // 방법. 바이트배열 문자화
//                System.out.println(by.length);
                System.out.println(msg); // 콘솔화면에 읽은 내용을 나타내기
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
