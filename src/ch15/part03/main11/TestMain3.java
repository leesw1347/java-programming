package ch15.part03.main11;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class TestMain3 {
    public static void main(String[] args) {
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        BufferedReader sis = null; // SequenceInputStream

        try {
            /**
             * FileInputStream fis1, fis2 객체생성
             * 2개 파일은 각자 존재하는 파일경로를 입력한다
             */
            String file1 = "D:\\IO\\file030902_path.txt";
            fis1 = new FileInputStream(file1);

            String file2 = "D:\\IO\\file030902_path2.txt";
            fis2 = new FileInputStream(file2);

            System.out.println(fis1);
            System.out.println(fis2);

            // Enumeration 타입을 만들기 위해 Vector 생성 후 자료 담기
            Vector<InputStream> list = new Vector<>();
            list.add(0, fis1);
            list.add(1, fis2);

            System.out.println("Vector<InputStream> length : " + list.size());
            System.out.println("Vector<InputStream> " + list);

            // 하나의 InputStream으로 처리함으로써 SequenceInputStream은
            // 처리의 편리성을 제공하는 보조 스트림 클래스로 판단하면 된다
            Enumeration<InputStream> elements = list.elements();

            /**
             * SequenceInputStream sis 객체 생성
             * 콘솔화면에 문자열을 나타내기 위해 문자스트림으로 변환
             * InputStreamReader 사용
             * 속도향상 및 readLine() 함수 사용을 위해 BufferedReader 사용
             */
            sis = new BufferedReader(new InputStreamReader(new SequenceInputStream(elements)));

            /**
             * 읽기작업
             */
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}