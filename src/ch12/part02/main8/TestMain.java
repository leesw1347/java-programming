package ch12.part02.main8;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // 자료구조 객체생성
        List<Integer> list = new ArrayList<>();

        // 자료추가
        for (int i = 0; i < 10; i++) {
            list.add(i * 10);
        }

        // 체크된 인덱스 파악
        int[] removeIndexArr = {0, 2, 4, 7, 9};

        // Iterator를 이용한 자료조회 및 자료삭제
        // Collection 인터페이스에서 제공하는 iterator() 함수를 이용하여, Iterator 객체를 얻을 수 있다
        Iterator<Integer> iterator = list.iterator();
        System.out.println(MessageFormat.format("iterator {0}", iterator));

        int index = 0;
        while (iterator.hasNext()) { // 다음 값이 있는지 조사
            // 자료 조회
            Integer next = iterator.next(); // 해당 값을 가져오면서, hasNext()는 다음 값의 여부를 나타낸다

            // 해당 인덱스와 같을 경우 삭제
            for (int i : removeIndexArr) {
                if (index == i) {
                    iterator.remove(); // 해당 값을 삭제한다 (remove는 반드시 자료에 접근한 이후에 실행되어야 한다)
                    break;
                }
            }
            index++;
        }
        // 결과자료 조회
        System.out.println(list);
    }
}
