package ch15.part03.main5.sub1;

import java.io.*;

public class TestMain {
    public static void main(String[] args) {

        /* BufferedReaderTest01.java 파일이 있는 상대 경로
         */
        String path = "src/ch15/part03/main5/sub1/TestMain.java";
        System.out.println(path);

        BufferedReader br = null;
        try {
            // BufferedReader 객체생성
            // LineNumberReader 클래스를 사용하여 다음과 같이 처리할 수 있다.
//            br = new BufferedReader(new FileReader(path));
            LineNumberReader lnr = new LineNumberReader(new FileReader(path));
//            System.out.println(br);

            // readLine()으로 자료를 읽어들이기
            while (true) {
                // readLine() 함수를 이용하면 작업처리가 매우 수월함을 알 수 있다.
//                String readLine = br.readLine();
                String readLine = lnr.readLine();
                if (readLine == null) {
                    break;
                }
                System.out.println(readLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 종료작업
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}