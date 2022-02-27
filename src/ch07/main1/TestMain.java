package ch07.main1;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.Arrays;

public class TestMain {
    /**
     * 테스트를 위한 메인 클래스
     * ProductVo 타입을 이용하여 배열 add(), update(), delete() 테스트
     * String 타입을 이용하여 배열 add(), update(), delete() 테스트
     * ProductVo[]에서 다음 값 가져오기
     * String[] : 헤더 정보 (항목명)
     * String[][] : 항목 자료 (품목 번호, 품목명, 단가)
     */
    public static void main(String[] args) {
        /**
         * ArrayUtil 클래스를 이용하여 배열을 동적으로 CRUD
         */
        String[] arr11 = {"a", "b", "c"};
        System.out.println("arr11 기존 - " + Arrays.toString(arr11));

        String[] arr12 = ArrayUtil.add(arr11, "dddd");
        System.out.println("arr12 추가 - " + Arrays.toString(arr12));

        String[] arr13 = ArrayUtil.remove(arr12, 0);
        System.out.println("arr13 삭제 - " + Arrays.toString(arr13));

        /**
         * 동일객체 여부 파악
         */
        boolean isSame1 = (arr11 == arr12);
        boolean isSame2 = (arr12 == arr13);
        String msg = MessageFormat.format("동일객체 여부 isSame1[{0}], isSame2[{1}]", isSame1, isSame2);
        System.out.println(msg);

        /**
         * ArrayUtil 클래스를 이용하여 배열을 동적으로 CRUD
         */
        int[] arr2 = {1, 2, 3};
        System.out.println("arr2 기존 - " + Arrays.toString(arr2));
        arr2 = ArrayUtil.add(arr2, 23);
        System.out.println("arr2 추가 - " + Arrays.toString(arr2));
        arr2 = ArrayUtil.remove(arr2, 0);
        System.out.println("arr2 삭제 - " + Arrays.toString(arr2));
        System.out.println();

        /**
         * ProductVo 객체생성
         */
        ProductVo v1 = new ProductVo("아메리카노", 3500);
        ProductVo v2 = new ProductVo("카페라떼", 4000);
        ProductVo[] productList = {v1, v2};

        /**
         * 품목코드를 확인
         */
        System.out.println();
        for (ProductVo vo : productList) {
            System.out.println("추가 전 ProductVo : " + vo);
        }
        System.out.println();

        /**
         * productList에 객체 추가
         */
        ProductVo v3 = new ProductVo("카페모카", 4500);
        System.out.println();

        productList = ArrayUtil.add(productList, v3);
        for (ProductVo v : productList) {
            System.out.println("추가 후 ProductVo : " + v);
        }
        System.out.println();

        /**
         * 품목정보를 화면에 나타내기 위하여 다음과 같은 타입 배열로 생성
         * 1. 항목 정보 : String[]
         *  2. 제품 목록 : String[][]
         *
         * 1. 항목 정보 : String[] headerNames 변환
         */
        String[] headerNames = ProductVo.TableInfo.HEADER_NAME_INFO;
        System.out.println("ProductVo 머리글 - " + Arrays.toString(headerNames));

        /**
         * ProductVo[] productList -> String[][] dataList로 변환
         */
        String[][] dataList = new String[productList.length][];
        for (int i = 0; i < dataList.length; i++) {
            dataList[i] = productList[i].getData();
        }

        /**
         * 3. 너비정보 -> int[] widthInfo 변환
         */
        int[] widthInfo = ProductVo.TableInfo.WIDTH_INFO;
        System.out.println("ProductVo 너비 - " + Arrays.toString(widthInfo));
    }
}