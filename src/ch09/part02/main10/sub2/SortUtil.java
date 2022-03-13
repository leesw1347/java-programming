package ch09.part02.main10.sub2;

import java.util.ArrayList;
import java.util.List;

public class SortUtil {

    // ProductVo 객체 값 정렬을 위한 함수 정의
    public static void sort(List<ProductVo> list) {
        // 정렬을 위해서는 최소한 2개 이상의 값이 존재해야 한다
        if (list == null || list.size() <= 1) return;

        boolean isChanged = false;
        while (true) {
            isChanged = false;

            for (int i = 0; i < list.size() - 1; i++) {

                // 순차적으로 list에 임의 자료와 그 다음 인덱스의 자료를 조회
                ProductVo p1 = list.get(i);
                ProductVo p2 = list.get(i + 1);
//                System.out.println(p1.getProductName() + ":" + p2.getProductName());

                // 두 값을 비교하기 위한 로직구성 - result
                // result : 1 (앞의 값이 크다), 0( 두 값이 같다 ), -1(앞의 값이 작다)
                int result = 0;
                if (p1 == null || p2 != null) {
                    result = 1;
                } else if (p1 != null && p2 == null) {
                    result = -1;
                } else if (p1 == null && p2 == null) {
                    result = 0;
                } else {
                    String productName1 = p1.getProductName();
                    String productName2 = p2.getProductName();
                    result = productName1.compareTo(productName2);
                }

                // 앞의 값이 클 경우만 자리 이동
                System.out.println("result " + result);
                if (result > 0) {
                    list.set(i, p2);
                    list.set(i + 1, p1);
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // list 객체생성 및 add() 함수를 이용하여 자료등록
        List<ProductVo> list = new ArrayList<ProductVo>();

        // list 객체에 자료등록
        list.add(new ProductVo("a001", "아메리카노", 4000));
        list.add(new ProductVo("a002", "카페라떼", 4300));
        list.add(new ProductVo("a003", "까페모카", 4500));

        // 전체 list 자료조회 및 콘솔화면 출력 - 정렬 전
        System.out.println("정렬 전 = " + list);
        SortUtil.sort(list); // 자료정렬 함수사용

        // 전체 list 자료조회 및 콘솔화면 출력 - 정렬전
        System.out.println("정렬 후 = " + list);
    }
}