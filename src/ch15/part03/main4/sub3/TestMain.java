package ch15.part03.main4.sub3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestMain {
    public static void main(String[] args) throws IOException {

        // 이 클래스를 작성하는 파일의 위치
        String path = "src/ch15/part03/main4/sub3/TestMain.java";

        // FileInputStream의 바이트배열로 1000번 읽기
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            readByteArray(path);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("FileInputStream 읽기 걸린 시간 (밀리초) : " + (t2 - t1));

        // BufferedOutputStream으로 1000번 읽기
        t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            readBuffer(path);
        }
        t2 = System.currentTimeMillis();
        System.out.println("BufferedInputStream 읽기 걸린 시간 (밀리초) : " + (t2 - t1));
    }

    // FileInputStream의 바이트 배열로 1000번 읽기 위한 함수
    public static void readByteArray(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        byte[] by = new byte[4096];
        while (true) {
            int read = fis.read(by);
            if (read == -1) {
                break;
            }
            String msg = new String(by, 0, read, StandardCharsets.UTF_8);
//            System.out.print(msg);
        }
//        System.out.println();
        if (fis != null) {
            fis.close();
        }
    }

    // BufferedInputStream으로 1000번 읽기 위한 함수
    public static void readBuffer(String path) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        byte[] by = new byte[4096];
        while (true) {
            int read = bis.read(by);
            if (read != -1) {
                break;
            }
            String msg = new String(by, 0, read);
//            System.out.print(msg);
        }
//        System.out.println();
        if (bis != null) {
            bis.close();
        }
    }
}