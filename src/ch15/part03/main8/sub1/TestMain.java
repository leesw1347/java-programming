package ch15.part03.main8.sub1;

import java.io.*;

/**
 * UTF-8로 쓰기작업하여 생성된 파일을 읽을 수 있다
 * UTF-8로 인코딩된 파일을 읽기 위한 작업 처리하기
 */
public class TestMain {
    public static void main(String[] args) {
        // 생성 파일 위치 지정
        String path = "D:\\IO\\IO.txt";

        // OutputStreamWriter 쓰기작업
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
            osw.write("테스트 UTF-8\r\n");
            osw.append("파일저장하기");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
