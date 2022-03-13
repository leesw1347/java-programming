package ch09.part02.main8.sub5;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    /**
     * 인터페이스는 표준화 된 기능 목록을 가진다
     */
    public static void main(String[] args) {

        // ArrayList 클래스는 인터페이스 List를 상속 받아서 구현했다
        List<String> list = new ArrayList<String>();
        list.add("data1"); // 자료저장
        list.add("data2"); // 자료저장
        list.add("data3"); // 자료저장
        list.add("data4"); // 자료저장
        list.add("data5"); // 자료저장

        // 리스트에 담긴 자료를 향상된 for문을 통하여 조회
        for (String s : list) {
            System.out.println("데이터 ::: " + s.toString());
        }
    }
}