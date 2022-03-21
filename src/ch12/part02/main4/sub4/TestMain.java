package ch12.part02.main4.sub4;

import java.text.MessageFormat;
import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("[list] 사용자 기준 정렬 - 이름 내림차순 정렬");
        List<MemberVo> list = new ArrayList<>();
        list.add(new MemberVo("p001", "아메리카노", 4000));
        list.add(new MemberVo("p002", "까페모카", 4500));
        list.add(new MemberVo("p003", "까페라떼", 4300));
        System.out.println(MessageFormat.format("\t정렬 전\t{0}", list));

        // 이름으로 내림차순 정렬
        Collections.sort(list, new Comparator<MemberVo>() {
            @Override
            public int compare(MemberVo o1, MemberVo o2) {
                // 사용자 정렬기준 정의
                // 대상(target)은 'o1'이며, 'o2(compare)'와 비교하여 대소 비교를 한다
                String name1 = o1.productName;
                String name2 = o2.productName;

                if (name1 == null && name2 == null) {
                    return 0;
                } else if (name1 == null && name2 != null) {
                    return -1;
                } else if (name1 != null && name2 == null) {
                    return 1;
                } else if (name1 != null && name2 != null) {
                    return name1.compareTo(name2);
                }
                return 0;
            }
        });
        System.out.println(MessageFormat.format("\t정렬 후\t{0}", list));
    }

    // MemberVo 내부클래스 정의
    public static class MemberVo {
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
            return MessageFormat.format("MemberVo[{0}.{1}.{2}]", productId, productName, price);
        }
    }
}
