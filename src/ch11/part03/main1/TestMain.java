package ch11.part03.main1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public void read() throws Exception {
        // 1) 파일의 경로(path)를 지정
        String path = "src/ch11/part03/main1/TestMain.java";

        // 절차1. 분리구간 시작
        // 2) 읽을 내용을 저장할 객체생성
        List<String> list = new ArrayList<>();

        // 3) 읽기 객체생성(BufferedReader br)
        BufferedReader br = new BufferedReader(new FileReader(path));
        // 4) 읽은 자료를 list에 저장
        while (true) {
            String readLine = br.readLine();
            if (readLine == null) {
                break;
            }
            list.add(readLine);
        }

        // 5) 읽기 객체 스트림 종료
        if (br != null) {
            br.close();
        }

        // 절차1) 분리구간 종료
        // 6) list 내용 확인
        int line = 1;
        for (String s : list) {
            System.out.println((line++) + "\t" + s);
        }
    }

    public static void main(String[] args) throws Exception {
        new TestMain().read();
    }
}
