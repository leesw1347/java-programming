package ch15.part03.main8.sub1;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * UTF-8로 쓰기작업하여 생성된 파일을 읽을 수 있다
 * UTF-8로 인코딩된 파일을 읽기 위한 작업 처리하기
 */
public class TestMain {
    public static void main(String[] args) {
        // 생성 파일 위치 지정
        String path = "D:\\IO\\IO.txt";

        // OutputStreamWriter 쓰기작업
        // 간단히 OutputStreamWriter로 쓰고, InputStreamReader로 읽는 과정을 나타냈다.
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
            osw.write("테스트 UTF-8\r\n");
            osw.append("파일저장하기");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (osw != null) {
                osw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // InputStreamReader 읽기작업
        BufferedReader br = null;

        /**
         * InputStreamReader에서는 데이터 양은 적지만, readLine()을 사용하기 위해서
         * BufferedReader를 추가
         */
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            while (true) {
                String readLine = br.readLine();
                if (readLine == null) {
                    break;
                }
                System.out.println(readLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
