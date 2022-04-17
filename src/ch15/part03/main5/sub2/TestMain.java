package ch15.part03.main5.sub2;

import java.awt.*;
import java.io.*;

/**
 * BufferedWriter를 이용해서 쓰기 작업을 할 수 있다.
 * FileWriter와 큰 차이가 없어 보이지만, BufferedWriter느 내부에서
 * 자료를 버퍼에 담고 있다가 기준값을 초과할 때마다 쓰기 작업을 하기 때문에 전송 회수를
 * 줄이고 전송량을 늘림으로써 속도를 개선한다.
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        // 쓰기작업을 할 파일 경로 지정
        String path = "D:\\IO\\IO.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        // 쓰기방법2. char 배열에 담아서 쓰기
        byte[] char_msg = "한글\r\n".getBytes("EUC-KR");
        bw.write(String.valueOf(char_msg));

        // 쓰기방법3. String 타입으로 직접 쓰기
        String msg = "test\r\n";
        bw.write(msg, 0, msg.length());

        // 버퍼에 담긴 자료를 파일에 쓰기
        bw.flush();

        try {
            if (bw != null) {
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 운영시스템으로 파일실행하기
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
