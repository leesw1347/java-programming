package ch10.part02.main3.sub3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMain2 {
    // try-with-resource 블록 개선안
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\test.txt"));

        // 2개 이상의 객체를 try() 내부에 콜론을 이용하여 입력
        FileReader fr = new FileReader("D:\\test.txt");
        BufferedReader br2 = new BufferedReader(fr);
        try (br; fr; br2) {
            // 절차2. 파일 읽기작업
            while (true) {
                String readLine = br.readLine(); // 파일에서 읽어오기
                if (readLine == null) {
                    break;
                }
                System.out.println(readLine); // 읽은 내용을 콘솔에 나타내기
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
