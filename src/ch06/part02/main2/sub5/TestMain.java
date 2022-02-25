package ch06.part02.main2.sub5;

public class TestMain {
    /**
     * 메인함수 정의
     * 배열로 나타내기
     * 반복문을 이용하여 조회하기
     * <p>
     * MemberVo member1, member2, member3 객체 생성
     */
    public static void main(String[] args) {
        MemberVo member1 = new MemberVo();
        member1.setMemberNo("a001");
        member1.setMemberName("김철수");
        member1.setCellPhone("010-1111-1111");

        MemberVo member2 = new MemberVo();
        member2.setMemberNo("a002");
        member2.setMemberName("이영희");
        member2.setCellPhone("010-2222-2222");

        /**
         * MemberVo 배열 객체 생성
         */
        MemberVo[] members = {member1, member2};

        /**
         * 배열객체 자료 조회
         */
        for (MemberVo m : members) {
            String info = m.getMemberNo();
            info += "\t" + m.getMemberName();
            info += "\t" + m.getCellPhone();
            System.out.println(info);
        }
    }
}
