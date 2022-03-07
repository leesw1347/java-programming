package ch08.part03.main3.sub1;

import java.io.File;
import java.text.MessageFormat;

public class TestMain2 {
    public static void main(String[] args) {

        /**
         * C 드라이브 경로 설정
         */
        StringBuffer path = new StringBuffer("C:\\");

        /**
         * File 객체생성
         */
        File file = new File(path.toString());

        /**
         * 해당 디렉토리 하위에 있는 File 객체 목록을 조회
         */
        File[] files = file.listFiles();
        if (files != null) {
            /**
             * File 객체목록 상세내역 조회
             */
            for (File f : files) {
                String name = f.getName();
                String isFile = (file.isFile() ? "파일" : "폴더");
                System.out.println(MessageFormat.format("{0}\t{1}", isFile, name));
            }
        }
    }
}