package ch15.part02.main2.sub3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {

        // 파일 경로 설정
        String path = "D:\\IO\\io2.txt";
        FileOutputStream fos = null;
        try {
            /** FileOutputStream 객체 생성
             * - 경로 내의 폴더가 없을 경우 FileNotFoundException 에러 발생
             * - fos.txt 파일이 없어도 자동으로 생성함
             */
            fos = new FileOutputStream(path);

            /* 쓰기방법1. byte로 직접쓰기 */
            fos.write((int) 't');
            fos.write((int) 'e');
            fos.write((int) 's');
            fos.write((int) 't');
            fos.write((int) '\r');
            fos.write((int) '\n');

            // 쓰기방법2. byte 배열에 담아서 쓰기
            byte[] msg = "한글".getBytes();
            fos.write(msg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 쓰기작업 종료하기
        try {
            if (fos != null) {
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 운영시스템으로 파일실행하기
        try {
//            Desktop.getDesktop().open(new File(path)); // 해당 파일이 존재할 경우, 해당 파일을 실행하기 위한 명령어임
            Desktop desk = Desktop.getDesktop();
            desk.open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
