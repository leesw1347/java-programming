package ch07.main1.part04.main2;

public enum Gender {

    /**
     * step 1) 괄호를 이용하여 넣고자 하는 enum 타입 값을 넣는다
     */
    MAN(1, "남자"), WOMAN(2, "여자");

    /**
     * step 2) private 생성자 함수를 [절차 1]의 괄호에 맞는 타입으로 정의

     private Gender(int value, String name){

     }
     */

    /**
     * 개선버전
     * step 3) 외부에서 name, value에 접근할 수 있도록 public 전역변수 생성

     public int value;
     public String name;
     */

    /**
     * step 5) public에서 private으로 변경한다
     */
    private int value;
    private String name;

    /**
     * step 6) getter 함수 생성
     */
    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    /**
     * step 4) 생성자 파라미터를 전역변수와 연결한다
     * 외부 new 연산을 이용한 객체생성 차단하기 위함이다
     * 앞에서 싱글톤 패턴의 정의에서도 언급한 바 있다
     */
    private Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }
}