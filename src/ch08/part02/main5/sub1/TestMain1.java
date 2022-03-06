package ch08.part02.main5.sub1;

import java.text.MessageFormat;
import java.util.ArrayList;

public class TestMain1 {
    /**
     * ArrayList에 자료를 저장 후 저장된 자료 조회하기
     */
    public static void main(String[] args) {
        /**
         * ArrayList 객체 생성
         */
        ArrayList list = new ArrayList();

        /**
         * 자료추가
         */
        list.add("1");
        list.add(2);
        System.out.println(list);

        /**
         * for문을 이용한 개별 자료 접근
         */
        for (Object t : list) {
            System.out.println(MessageFormat.format("{0},{1}", t, t.toString()));
        }
    }
}
