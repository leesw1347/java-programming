package ch09.part01.main1;

public class TestMain {


    public static void main(String[] args) {
        /**
         * ProductVo 객체생성 - 속성설정 - 객체정보 조회
         */
        ProductVo v1 = new ProductVo();
        v1.setPrice(1000);
        v1.setProductName("아메리카노");
        v1.setProductNo("a001");
        System.out.println(v1); // v1.toString() 함수가 실행됨

        /**
         * MemberVo 객체생성 - 속성설정 - 객체정보 조회
         */
        MemberVo v2 = new MemberVo();
        v2.setMemberId("m001");
        v2.setMemberName("홍길동");
        System.out.println(v2); // v2.toString() 함수가 실행됨
    }
}