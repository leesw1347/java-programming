package ch12.part02.main5;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        // List 객체생성
        List<Integer> list = new ArrayList<>();

        // 오토박싱 : int -> Integer 자동변환
        int data1 = 1;
        list.add(data1);
        Object data2 = list.get(0);
        
        // 오토박싱 : 1, 타입 : class java.lang.Integer
        System.out.println("오토박싱 : " + data2 + ", 타입 : " + data2.getClass());

        // 언오토박싱 : Integer -> int 자동변환
        int data3 = list.get(0);
        System.out.println("언오토박싱 : " + data3);
    }
}
