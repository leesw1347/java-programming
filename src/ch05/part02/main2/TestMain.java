package ch05.part02.main2;

import java.io.StringReader;
import java.text.MessageFormat;

public class TestMain {
    public static void main(String[] args) {

        /**
         * 반복문 for 문을 이용하여 1부터 100까지의 합 구하기
         */
        int sum1 = 0;
        for (int i = 1; i <= 100; i++) {
            sum1 += i;
        }
        System.out.println("1부터 100까지의 합은 [" + sum1 + "]입니다");

        /**
         * 반복문 while 문을 이용하여 1부터 100까지의 합 구하기
         */
        int index = 0;
        int sum2 = 0;

        while (index <= 100) {
            sum2 += (index++);
        }
        System.out.println("1부터 100까지의 합은 [" + sum2 + "]입니다");

        /**
         * 반복문 for문을 이용하여 1부터 100까지 짝수 값의 합 구하기
         */
        int sum3 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) continue;
            sum3 += i;
        }
        System.out.println("1부터 100까지의 합은 [" + sum3 + "]입니다");

        /**
         * 반복문 : 1부터 1씩 증가하여 값을 더할 때 최초로 3000이 넘는 정수의 값 구하기
         */
        int index4 = 0;
        int sum4 = 0;
        while (true) {
            sum4 += (index4++);
            if (sum4 >= 3000) break;
        }
        String Message = MessageFormat.format("1부터 1씩 증가하여 값을 더할 때 그 합이 최초로 ''3000이 넘기는 정수는 [{0}]이며, 합의 값은 [{1}]이다.", index4, sum4);
        System.out.println(Message);
    }
}