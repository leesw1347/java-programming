package ch10.part01.main1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead2 {
    // 읽기 객체 선언
    public static void read(String path) {
        // 읽기객체선언
        BufferedReader br = null;

        // 예외처리를 위한 try 구간 정의
        try {
            // 읽기절차1 : 읽기객체생성
            br = new BufferedReader(new FileReader(path));

            // 읽기절차2 : 파일읽기
            while (true) {
                String readLine = br.readLine();
                if (readLine == null) {
                    break;
                }
                System.out.println(readLine);
            }

        } catch (FileNotFoundException e) {
            // 해당 파일의 경로에 파일이 없는 경우에 에러 처리 구간
            e.printStackTrace();
        } catch (IOException ex) {
            // 스트림을 이용하여 읽기/쓰기 작업 시 발생하는 에러 처리 구간
            ex.printStackTrace();
        } finally { // 예외처리를 위한 finally
            // 읽기절차3. 파일읽기종료
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 메인 함수 정의
    public static void main(String[] args) {
        // 경로설정 후 파일읽기
        String path = "src/ch01/part01/main1/FileRead2.java";
        FileRead2 fr = new FileRead2();
        fr.read(path);
    }
    // 경로 설정 후 파일 읽기
}
