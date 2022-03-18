package ch10.part02.main3.sub3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        /**
         * AutoCloseable 인터페이스를 구현한 클래스에서 사용이 가능하다
         * 처리과정상 close() 함수가 있는 경우를 고려하면 된다
         * 해당 객체는 final 객체이며 내부에서 변수값 변경이 불가능하다
         */

        // step 1) 파일을 읽기 위한 객체 생성
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\test.txt"))) {
            // step 2) 파일 읽기 작업
            while (true) {
                String readLine = br.readLine(); // 파일에서 읽어오기
                if (readLine == null) {
                    break;
                }
                System.out.println(readLine); // 읽은 내용을 콘솔에 나타내기
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
