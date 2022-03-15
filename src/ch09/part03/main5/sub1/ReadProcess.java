package ch09.part03.main5.sub1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadProcess {
    public static void main(String[] args) throws IOException {

        // 현재 파일을 읽기 위한 경로 설정
//        Path currentPath = Paths.get(".");
//        String filePath = currentPath.toUri().toString();
//        System.out.println(filePath);

        String filePath = "src/ch09/part03/main6/ReadProcess.java";
//        System.out.println(filePath.toString());

        // 파일을 읽을 클래스 객체 생성
        // FileReader 클래스 : 파일을 읽기 위한 클래스
        // BufferedReader 클래스 : 파일에 버퍼 기능을 이용하기 위한 클래스
        //  BufferedReader 클래스를 이용하면 개행 단위로 파일을 읽어올 수 있음
        //  br.readline();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        System.out.println(br);

        // 파일 읽기 작업 - 무한루프
        while (true) {
            // 한줄 씩 읽어오기
            // 라인 단위로 자료를 읽을 수 있고, 마지막 readline의 값은 null이기 때문에
            // 반드시 종료 처리를 해줘야 한다
            String readLine = br.readLine();
            if (readLine == null) {
                break;
            }

            // 분리하고자 하는 로직 시작 구간
            if (!readLine.trim().equals("")) {
                System.out.println(readLine);
            }

            // 분리하고자 하는 로직 종료 구간
        }
        br.close();
    }
}
