package ch07.main1.part04.main1;

public class TypeA {

    /**
     * enum 타입의 정의
     */
    public enum GenderType {
        MAN, WOMAN
    }

    /**
     * GenderType 전역변수 생성
     */
    private GenderType genderType;

    /**
     * GenderType getter 함수 생성
     */
    public GenderType getGenderType() {
        return genderType;
    }

    /**
     * genderType setter 함수 생성
     */
    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }
}
