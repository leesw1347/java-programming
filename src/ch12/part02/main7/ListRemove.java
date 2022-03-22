package ch12.part02.main7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRemove {
    public static void main(String[] args) {
        // 자료구조 객체생성
        List<Integer> list = new ArrayList<>();

        // 자료의 추가
        for (int i = 0; i <= 10; i++) {
            list.add(i * 10);
        }

        // 체크된 인덱스 파악
//        int[] removeIndexArr = {1, 3, 5};
        int[] removeIndexArr = {0, 2, 4, 7, 9};

        // 배열자료의 기본정렬
        Arrays.sort(removeIndexArr);

        // 인덱스를 이용한 일괄자료삭제는 뒤에서부터 삭제처리한다
        for (int i = removeIndexArr.length - 1; i >= 0; i--) {
            int index = (int) removeIndexArr[i];
            list.remove(index);
        }

        // 해당 인덱스의 자료 삭제
//        for (int i = 0; i < removeIndexArr.length; i++) {
//            int index = (int) removeIndexArr[i];
//            list.remove(index);
//        }

        // 결과자료 조회
        System.out.println(list);
    }
}
