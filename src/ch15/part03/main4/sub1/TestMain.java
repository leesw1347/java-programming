package ch15.part03.main4.sub1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        String path = "src/ch15/part03/main4/sub1/TestMain.java";
        System.out.println(path);

        // BufferedInputStream 객체생성 -> 읽기작업
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(path));
            System.out.println(bis);
            byte[] by = new byte[10];

            while (true) {
                int read = bis.read(by);
                if (read == -1) {
                    break;
                }

                String msg = new String(by, 0, read);
                System.out.print(msg.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (bis != null) {
                bis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}