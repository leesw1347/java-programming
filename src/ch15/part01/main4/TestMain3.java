package ch15.part01.main4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain3 {
    public static void main(String[] args) {
        // 삭제할 "폴더"의 Filㄷ 타입 객체생성
        File file = new File("D:\\FileTest2");

        // 모듈화된 함수를 사용
        deleteAll(file);
    }

    // 모듈화 된 함수 정의 - 소스 개선
    public static void deleteAll(File file) {
        // 삭제할 File 객체 및 하위 File 객체목록을 저장할 List<File> 객체생성
        List<File> list = new ArrayList<>();

        // 해당 File 객체의 하위 File 객체목록을 조회
        scan(file, list);

        // list에 담긴 자료를 역순으로 정렬
        Collections.reverse(list);

        // list에 담긴 자료를 삭제
        for (File f : list) {
            f.delete();
            // 존재여부가 모든 false여야 한다
            System.out.println(f.getAbsolutePath() + " : 존재여부 " + f.exists());
        }
    }

    private static void scan(File file, List<File> list) {
        if (file == null) {
            return;
        }
        list.add(file);
        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            if (f.isFile()) {
                list.add(f);
            } else {
                scan(f, list); // 재귀함수 사용
            }
        }
    }
}
