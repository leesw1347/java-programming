package ch06.part02.main2.sub5;

public class MemberVo {
    /**
     * 전역변수 정의 : memberNo, memberName, cellPhone
     * getter & setter 함수 정의
     */

    private String memberNo;
    private String memberName;
    private String cellPhone;

    /**
     * getter & setter 함수 정의
     */
    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
