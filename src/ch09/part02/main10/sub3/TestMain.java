package ch09.part02.main10.sub3;

import ch09.part02.main10.sub2.ProductVo;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        // 1. List 객체생성 및 자료등록
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(0);
        list1.add(4);
        list1.add(3);
        list1.add(1);
        list1.add(2);
        list1.add(5);

        // 전체 list 자료조회 및 콘솔화면 출력 - 정렬전
        System.out.println("처리 전 = " + list1);

        // 자료정렬 함수사용 - Integer 타입 객체의 정렬을 직접 정의
        SortUtil.sort(list1, new SortUtil.Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                int result = 0;
                if (t1 > t2) {
                    result = 1;
                } else if (t1 < t2) {
                    result = -1;
                }
                return result;
            }
        });

        // 전체 list 자료조회 및 콘솔화면 출력 - 정렬 후
        System.out.println("처리 전 = " + list1);

        // list 객체 생성 및 add() 함수를 이용하여 자료 등록
        List<ProductVo> list2 = new ArrayList<ProductVo>();

        // 2. list 객체에 자료등록
        list2.add(new ProductVo("a001", "아메리카노", 4000));
        list2.add(new ProductVo("a002", "까페라떼", 4300));
        list2.add(new ProductVo("a003", "까페모카", 4500));

        // 전체 list 자료조회 및 콘솔화면 출력 - 정렬전
        System.out.println("정렬 전 = " + list2);

        // 자료정렬 함수 사용 - ProductVo 타입 객체의 정렬을 직접 정의
        SortUtil.sort(list2, new SortUtil.Comparator<ProductVo>() {
            @Override
            public int compare(ProductVo t1, ProductVo t2) {
                int result = 0;
                if (t1 == null && t2 != null) {
                    result = 1;
                } else if (t1 != null && t2 == null) {
                    result = -1;
                } else if (t1 == null && t2 == null) {
                    result = 0;
                } else {
                    String productName1 = t1.getProductName();
                    String productName2 = t2.getProductName();
                    result = productName1.compareTo(productName2);
                }
                return result;
            }
        });
        // 전체 list 자료조회 및 콘솔화면 출력 - 정렬후

        System.out.println(list2);
    }
}
