package ch15.part01.main4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        // 삭제할 폴더의 File 타입 객체생성
        File file = new File("D:\\FileTest2");

        // list에 담긴 자료를 역순으로 정렬

        // 삭제할 File 객체 및 하위 File 객체목록을 저장할 List<File> 객체생성
        List<File> list = new ArrayList<>();

        // 해당 File 객채의 하위 File 객체 목록을 조회

        // 로직처리1
        list.add(file);

        // 해당 폴더의 하위 자료 검색
        System.out.println(list.toString());

        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            // 파일일 경우 리스트에 담는다
            if (f.isFile()) {
                list.add(f);
            }

            // 폴더의 경우 다시 해당 하위 파일을 검색한다
            else {
                // 로직처리1과 동일한 로직패턴이 발생 - 재귀함수 이용
                list.add(f);
                File[] listFiles2 = f.listFiles();
                for (File f2 : listFiles2) {
                    // 파일일 경우 리스트에 담는다
                    if (f.isFile()) {
                        list.add(f2);
                    }
                    // 폴더의 경우 다시 해당 하위 파일을 검색한다
                    else if (f.isDirectory()) {
                    }
                }
            }
        }
    }
}
