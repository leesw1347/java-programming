package ch08.part03.main3.sub2;

import java.io.File;
import java.text.MessageFormat;

public class TestMain {

    /**
     * 파일의 정보를 받아와 하위 폴더 및 파일의 목록을 조회
     * File 객체가 null 또는 존재하지 않는 파일 정보일 때 종료
     */
    public static void scan(File file) {
        if (file == null || !file.exists()) {
            return;
        }

        /**
         * 폴더의 경우 다시 하위폴더 조회
         */
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    /**
                     * 파일의 정보를 받아와 하위 폴더 및 파일의 목록을 조회
                     */
                    scan(f);
                }
            }
        }
        /**
         * 파일의 경우 파일의 정보를 조회
         */
        else{
            String isFile = (file.isFile() ? "파일" : "폴더");
            String name = file.getName();
            String path = file.getAbsolutePath();
            System.out.println(MessageFormat.format("isFile {0}\t{1}\t{2}", isFile, name, path));
        }
    }

    public static void main(String[] args) {
        /**
         * 해당 폴더 및 하위폴더의 정보를 가져오기
         */
        StringBuffer rootPath = new StringBuffer("F:\\java");

        /**
         * File 객체 생성
         */
        File file = new File(rootPath.toString());

        /**
         * scan() 함수 호출
         */
        scan(file);
    }
}