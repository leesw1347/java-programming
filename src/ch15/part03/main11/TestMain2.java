package ch15.part03.main11;

import java.io.*;

public class TestMain2 {
    public static void main(String[] args) {
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        BufferedReader sis = null;

        try {
            /**
             * FileInputStream fis1, fis2 객체생성
             * 2개 파일은 각자 존재하는 파일경로를 입력하길 바란다
             * 2개 파일은 이전에 학습한 파일이므로, 학습자에 맞게 경로 설정 후 처리하길 바란다
             */
            fis1 = new FileInputStream("D:\\IO\\file030902_path.txt");
            fis2 = new FileInputStream("D:\\IO\\file030902_path2.txt");

            /**
             * SequenceInputStream sis 객체생성
             *  콘솔 화면에 문자열을 나타내기 위해 문자스트림으로 반환
             *  InputStreamReader 사용
             *  - 속도 향상 및 readLine() 함수 사용을 위해 BufferedReader 사용
             */
            sis = new BufferedReader(new InputStreamReader(new SequenceInputStream(fis1, fis2)));
            System.out.println(sis);

            // 읽기작업
            while (true) {
                String readLine = sis.readLine();
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

        // 종료작업
        try {
            if (sis != null) {
                sis.close();
                fis1.close();
                fis2.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}