package ch09.part03.main5.sub3;

import java.awt.desktop.ScreenSleepEvent;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 클래스 모듈화
 * [2] 유틸성 클래스 메소드를 이용한 모듈화
 * 주로 특정 업무의 기능 처리를 위해 로직 내부에서 사용한다
 */
public abstract class ReadUtils implements IReadProcess {

    // read() 함수 정의 - 경로와 읽기 작업을 위한 인터페이스 파라미터 사용
    public static void read(String path, IReadProcess readProcess) throws Exception {
        // 파일을 읽어오기 위한 객체 생성
        BufferedReader br = new BufferedReader(new FileReader(path));

        // 읽기 작업
        while (true) {
            // 한줄씩 읽어오기
            String readLine = br.readLine();
            // 파일을 다 읽을 경우, null을 반환, 루프 벗어나기
            if (readLine == null) {
                break;
            }

            // 개별 기능 처리
            readProcess.execute(readLine);
        }
        br.close();
    }


    public static void main(String[] args) throws Exception {
        // 경로 설정
        String filePath = "src/ch09/part03/main5/sub1/ReadProcess.java";

        // read() 함수로 파일 읽기 - 경로와 읽기 작업을 위한 익명클래스 객체 이용
        // 기능목록 정의를 위한 인터페이스 정의
        ReadUtils.read(filePath, new IReadProcess() {
            @Override
            public void execute(String readLine) {
                // 상세로직 구현
                if (!readLine.trim().equals("")) {
                    System.out.println(readLine);
                }
            }
        });
    }
}
