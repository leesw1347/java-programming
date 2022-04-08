package ch15.part01.main4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain2 {
    public static void main(String[] args) {
        // 삭제할 File 객체 및 하위 File 객체목록을 저장할 List<File> 객체생성
        List<File> list = new ArrayList<>();

        // 해당 File 객체의 하위 File 객체목록을 조회

        // 삭제할 '폴더'의 File 타입 객체생성
        File file = new File("D:\\FileTest2");

        // 절차6. 분리한 로직영역에 재귀함수를 사용한다
        scan(file, list);

        // list에 담긴 자료를 역순으로 정렬
        Collections.sort(list);

        // list에 담긴 자료를 삭제
        for (File f : list) {
            if (f.isFile()) {
                boolean delete_result = f.delete();
                System.out.println(delete_result);
                // 존쟁부가 모두 false여야 한다
                System.out.println(f.getAbsolutePath() + " 존재여부 : " + f.exists());
            }
        }

        System.out.println(list.toString());
    }

    // 절차1. 공통로직을 위한 함수 정의
    // 절차3. 공통로직 이동 후 오류가 발생하는 변수를 파라미터로 연결
    private static void scan(File file, List<File> list) {
        // 절차5. 파라미터의 null 조건 처리 등 종료를 위한 로직을 추가
        if (file == null) {
            return;
        }
        // 절차 2. 공통로직을 가져온다.
        list.add(file);
        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            if (f.isFile()) {
                list.add(f);
            } else if (f.isDirectory()) {
                // 절차 4. 로직처리1과 동일한 로직패턴은 재귀함수 이용
                scan(f, list);
            }
        }
    }
}
