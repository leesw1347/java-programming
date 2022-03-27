package ch12.part05.main1.sub4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestMain {
    public static void main(String[] args) {
        // 상대경로는 src/ch12/part05/main1/sub4/conf.properties가 된다
        // 상대 경로에 대해서는 15장에서 절대 경로와 상대 경로에 대해 상세하게 학습할 계획이다

        // Properties 객체생성
        Properties prop = new Properties();

        // 자료저장
        prop.put("1", "a");
        prop.put("2", "b");
        prop.put("3", "c");
        prop.put("4", "d");
        prop.put("5", "e");

        FileOutputStream fos = null;
        try {
            // FileOutputStream 객체생성
            fos = new FileOutputStream("src/ch12/part05/main1/sub4/conf.properties");

            // 자료 쓰기 작업
            prop.store(fos, "configuration file setting");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // FileOutputStream 종료
        try {
            if (fos != null) {
                fos.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
