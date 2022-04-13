package ch15.part03.main4.sub2;

import java.awt.*;
import java.io.*;

public class TestMain {

    /**
     * BuffereedOutputStream은 보조스트림으로서 바이트 배열을 다룸
     * 실제 파일의 전송 횟수를 줄이기 위해서 전송량을 늘려 속도를 향상 시키기 위한 클래스이a
     */
    public static void main(String[] args) throws IOException {
        /**
         * 임의의 경로에 생성할 파일의 경로를 설정한다
         * 부모 폴더가 존재하지 않을 경우 FileNotFoundException 에러가 발생한다
         */
        String path = "D:\\IO\\io5_writer.txt";
        BufferedOutputStream bos = null;

        try {
            // BufferedOutputStream 객체생성
            bos = new BufferedOutputStream(new FileOutputStream(path));
            if (bos != null) {
                // 바이트로 쓰기 작업
                bos.write('t');
                bos.write('e');
                bos.write('s');
                bos.write('t');

                // 바이트 배열로 쓰기 작업
                bos.write("\r\n".getBytes());
                bos.write("BufferedOutputStream 쓰기작업 연습".getBytes());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 운영시스템으로 파일 실행
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bos != null) {
            bos.close();
        }
    }
}
