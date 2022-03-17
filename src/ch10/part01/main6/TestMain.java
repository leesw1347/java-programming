package ch10.part01.main6;

import java.io.File;
import java.io.FileNotFoundException;

public class TestMain {
    // read() 함수 정의, 예외를 위임
    public void read(String path) throws FileNotFoundException {
        // 파일 관리를 위한 File 객체 생성 및 존재 여부 확인
        File file = new File(path);
        boolean exists = file.exists();
        if (!exists) {
            System.out.println("파일 존재 안함");
            // [절차1] 예외 발생시키기
            throw new FileNotFoundException("해당 파일이 존재하지 않습니다");
        } else {
            System.out.println("파일 존재함");
        }
    }

    // 메인함수 정의
    public static void main(String[] args) {
        // read()함수 사용 시 예외처리, 존재하지 않는 파일을 설정
        try {
            // read 함수를 사용 시 예외처리, 존재하지 않는 파일을 설정
            new TestMain().read("d://test11.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
