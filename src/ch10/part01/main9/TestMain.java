package ch10.part01.main9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMain {

    public static void main(String[] args) {
        // step 1) 파일을 읽기 위한 객체 생성 - 파일에 스트림 연결
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\test.txt"));

            // step 2) 파일 읽기 작업
            while (true) {
                try {
                    String readLine = br.readLine(); // 파일에서 읽어오기
                    if (readLine == null) { // null이 나오면 다 읽은 것임
                        break;
                    }
                    System.out.println(readLine); // 읽은 내용을 콘솔에 나타내기
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
