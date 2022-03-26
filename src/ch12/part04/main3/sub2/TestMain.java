package ch12.part04.main3.sub2;

import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        // 객체생성
        HashMap<String, MemberVo> map1 = new HashMap<>();

        // MemberVo 객체생성
        MemberVo member1 = new MemberVo("a001", "홍길동");
        MemberVo member2 = new MemberVo("a002", "이순신");

        map1.put("a001", member1);
        map1.put("a002", member2);

        System.out.println(" 객체생성 및 자료등록 ");
        System.out.println("map1 = " + map1);
        System.out.println();

        // 자료복사 - Depp Copy
        Map<String, String> map2 = (Map<String, String>) map1.clone();
        System.out.println(" 자료복사 (Deep Copy)");
        System.out.println("map2 = " + map2);
        System.out.println();

        // 자료 member1 속성변경
        member1.memberId = "p001";
        System.out.println(" member1 속성변경 : 'a001' -> 'p001'");
        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);
        System.out.println();

        // 자료의 추가
        MemberVo member3 = new MemberVo("a003", "강감찬");
        map1.put("a003", member3);
        System.out.println(" member3 객체 자료 등록 " + member3);
        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);
    }

    // MemberVo 클래스 정의
    public static class MemberVo {
        public MemberVo(String memberId, String memberName) {
            this.memberId = memberId;
            this.memberName = memberName;
        }

        private String memberId;
        private String memberName;

        @Override
        public String toString() {
            return "MemberVo{" +
                    "memberId='" + memberId + '\'' +
                    ", memberName='" + memberName + '\'' +
                    '}';
        }
    }
}
