package ch15.part02.main2;

import java.awt.desktop.SystemSleepEvent;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 자바 기본 인코딩 검색하기
        String property = System.getProperty("file.encoding");
        System.out.println("기본 인코딩방식 : " + property);
        System.out.println();

        // 한글 "문자열" 인코딩/디코딩 처리
        String msg1 = "한글";
        byte[] bytes1 = msg1.getBytes();
        byte[] bytes2 = msg1.getBytes("MS949");
        byte[] bytes3 = msg1.getBytes("EUC-KR");
        byte[] bytes4 = msg1.getBytes(StandardCharsets.UTF_8);

        // 인코딩된 바이트 값 조회
        System.out.println("기본방식 : " + Arrays.toString(bytes1));
        System.out.println("MS949 : " + Arrays.toString(bytes2));
        System.out.println("EUC-KR : " + Arrays.toString(bytes3));
        System.out.println("UTF-8 : " + Arrays.toString(bytes4));

        // 한글 바이트 수 팡가하기
        System.out.println("한글 문자열의 길이 : " + msg1.length());
        System.out.println("기본방식 바이트 수 : " + bytes1.length);
        System.out.println("MS949 바이트 수 : " + bytes2.length);
        System.out.println("EUC-KR 바이트 수 : " + bytes3.length);
        System.out.println("UTF-8 바이트 수 : " + bytes4.length);
        System.out.println();

        // 인코딩된 바이트 배열을 디코딩하기
        System.out.println("기본방식 디코딩 : " + new String(bytes1));
        System.out.println("MS949 디코딩 : " + new String(bytes2, "MS949"));
        System.out.println("EUC-KR 디코딩 : " + new String(bytes3, "EUC-KR"));
        System.out.println("UTF-8 디코딩 : " + new String(bytes4, StandardCharsets.UTF_8));
        System.out.println();

        // 한글을 EUC-KR로 인코딩 한 후 UTF-8로 디코딩 결과확인
        String msg21 = "한글";
        byte[] bytes21 = msg21.getBytes("EUC-KR");
        String msg22 = new String(bytes21, StandardCharsets.UTF_8);
        System.out.println("한글 EUC-KR 인코딩 -> UTF-8 디코딩 : " + msg22);

        // 한글 UTF-8로 인코딩 한 후, EUC-KR로 디코딩 결과 확인
        byte[] bytes31 = msg21.getBytes(StandardCharsets.UTF_8);
        String msg31 = new String(bytes31, "EUC-KR");
        System.out.println("UTF-8 인코딩 -> EUC-KR 디코딩 " + msg31);
    }
}
