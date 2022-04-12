package ch15.part03.main3.sub2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        String path = "D:\\IO\\io4_writer.txt";
        FileWriter fw = null;
        try {
            /**
             * 경로설정
             * 경로 내의 폴더가 없을 경우 FileNotFoundException 에러 발생
             * io4_writer.txt 파일이 없어도 자동으로 생성함
             */
            fw = new FileWriter(path);

            // 쓰기방법1. char로 쓰기
            fw.write('t');
            fw.write('e');
            fw.write('s');
            fw.write('t');
            fw.write('\r');
            fw.write('\n');

            // 쓰기방법2. byte 배열에 담아서 쓰기
            char[] msg = "한글\r\n".toCharArray();

            // 쓰기방법3. String 타입으로 직접 쓰기
            fw.write("FileWriter 쓰기연습");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 운영시스템으로 파일 실행하기
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
