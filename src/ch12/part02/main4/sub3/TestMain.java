package ch12.part02.main4.sub3;

import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사용자 클래스 기본정렬을 이해하도록 합니다
 * Comparaable 인터페이스 구현 후 추상 메소드에 의한 정렬 기준 정의
 */
public class TestMain {

    public static void main(String[] args) {
        /**
         * List에 MemberVo 타입을 정렬
         */
        System.out.println("[list1] 정렬");
        List<MemberVo> list = new ArrayList<>();
        list.add(new MemberVo("p001", "아메리카노", 4000));
        list.add(new MemberVo("p002", "까페모카", 4500));
        list.add(new MemberVo("p003", "까페라떼", 4300));

        // 자료 오름차순 기본정렬
        System.out.println(MessageFormat.format("\t정렬 전\t{0}", list));
        Collections.sort(list);
        System.out.println(MessageFormat.format("\t정렬 후\t{0}", list));
    }

    // 기본정렬을 정의하기 위해 Comparable 인터페이스 구현
    public static class MemberVo implements Comparable<MemberVo> {

        private String productId;
        private String productName;
        private int price;

        public MemberVo(String productId, String productName, int price) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
        }

        @Override
        public String toString() {
//            return super.toString();
            return MessageFormat.format("MemberVo[{0}.{1}.{2}]", productId, productName, price);
        }

        // Comparable 인터페이스에 정의된 추상메소드 구현
        @Override
        public int compareTo(@NotNull TestMain.MemberVo o) {
            // 기본정렬에 대한 정렬기준 정의
            // 반환 값이 양수이면 자기자신객체 this가 큰 값
            // 반환 값이 음수이면 자기자신객체 this가 작은 값
            // 반환 값이 같으면 자기자신객체 this와 o는 같은 값
            if (this.price > o.price) {
                return 1;
            } else if (this.price == o.price) {
                return 0;
            } else {
                return -1;
            }
        }
    }

}
