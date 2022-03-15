package ch09.part03.main5.sub2;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class AbstractReadFile {
    public abstract String getFilePath();

    public abstract void process(String readLine);

    public void read() throws Exception {
        // 읽기 객체생성 - getFilePath() 추상메소드 사용
        String filePath = getFilePath();

        // 파일을 읽을 클래스 객체 생성
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        // 읽기 작업
        while(true){
            // 한줄씩 읽어오기
            String result = br.readLine();
            if (result == null){
                // 파일을 다 읽을 경우 null을 반환, 루프 벗어나기
                break;
            }

            // 추상메소드의 사용
            process(result);
        }
        br.close();
    }
}
