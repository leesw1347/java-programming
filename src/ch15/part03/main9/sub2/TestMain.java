package ch15.part03.main9.sub2;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class TestMain {
    public static void main(String[] args) {
        // PrintStream 출력파일경로 지정
        String path = "D:\\IO\\file030902_path.txt";
        PrintStream ps = null;

        try {
            // PrintStream 객체생성
            ps = new PrintStream(path, StandardCharsets.UTF_8);
            System.out.println(ps);

            // printf(), print(), println() 함수의 사용
            ps.printf("%1$4ty", Calendar.getInstance());
//            ps.printf("test한글%.07d %n", 1233);
            ps.print("test");
            ps.println("println() 사용");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 종료작업
        if (ps != null) {
            ps.close();
        }

        // 운영시스템으로 파일실행하기
        try {
            Desktop.getDesktop().open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // PrintWriter 출력파일경로 지정
        String path2 = "D:\\IO\\file030902_path2.txt";
        PrintWriter pw = null;
        try {
            // PrintWriter 객체생성
            pw = new PrintWriter(path2);

            pw.print("test");
            pw.println("println() 사용");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (pw != null) {
            pw.close();
        }

        // 운영시스템으로 파일 실행하기
        try {
            File file = new File(path2);
            if (file != null) {
                Desktop.getDesktop().open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}