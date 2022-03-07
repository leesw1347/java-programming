package ch08.part03.main3.sub1;

import javax.swing.text.html.StyleSheet;
import java.io.File;
import java.text.MessageFormat;

public class TestMain1 {
    /**
     * 메인함수 정의
     * 물리 파일의 경로 설정
     * File 객체 생성
     * 해당 물리 파일의 절대 경로 조회
     * 해당 물리 파일의 파일명을 조회
     * 해당 물리 파일의 존재 여부를 조회
     * 해당 물리 파일의 파일 타입인지 조회
     * 해당 물리 파일이 디렉토리 타입인지 조회
     */

    public static void main(String[] args) {
        /**
         * 물리파일의 경로설정
         */
        StringBuffer path = new StringBuffer("F:\\java\\test.txt");

        /**
         * File 객체 생성
         */
        File file = new File(path.toString());

        /**
         * 해당 물리파일의 절대경로 조회
         */
        String absolutePath = file.getAbsolutePath();
        System.out.println(MessageFormat.format("absolutePath = {0}", absolutePath));

        /**
         * 해당 물리파일의 파일명을 조회
         */
        String name = file.getName();
        System.out.println(MessageFormat.format("name = {0}", name));

        /**
         * 해당 물리파일이 파일타입인지 조회
         */
        boolean isFile = file.isFile();
        System.out.println(MessageFormat.format("isFile = {0}", isFile));

        /**
         * 해당 물리파일이 디렉토리타입인지 조회
         */
        boolean isDirectory = file.isDirectory();
        System.out.println("isDirectory = " + isDirectory);

    }
}
