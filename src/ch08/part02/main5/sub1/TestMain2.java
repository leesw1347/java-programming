package ch08.part02.main5.sub1;

import java.util.ArrayList;

/**
 * 제네릭스를 이용하여 ArrayList에 자료를 저장 후 저장된 자료 조회하기
 */

public class TestMain2 {

    public static void main(String[] args) {
        /**
         * 제네릭스를 이용한 ArrayList 객체 생성
         * 해당 자료 구조는 모두 String 타입의 자료만 저장하겠다는 뜻이된다.
         */
        ArrayList<String> list = new ArrayList<String>();

        /**
         * 자료 추가
         */
        list.add("a");
        list.add("b");
        System.out.println(list);

        /**
         * 향상된 for문을 이용한 개별 자료 접근!
         */
        System.out.println(list.isEmpty());
        for(String s : list){
            System.out.println(s);
        }
    }
}
