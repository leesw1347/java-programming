package ch07.main1.part03.main1.sub2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestMain {
    /**
     * 품목 그리드 관련 공통 정보 조회
     * 품목 그리드 관련 공통 정보 출력
     */
    public static void main(String[] args) {
        /**
         * 품목 그리드 관련 공통정보 출력
         */
        String[] headerInfo = ProductVo.TableInfo.HEADER_INFO;
        int[] widthInfo = ProductVo.TableInfo.WIDTH_INFO;

        /**
         * 품목 그리드 관련 공통정보 출력
         */
        System.out.println(Arrays.toString(headerInfo));
        System.out.println(Arrays.toString(widthInfo));
    }
}