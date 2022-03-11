package ch09.part01.main6;

public class TestMain {
    /**
     * 메인 함수 정의
     * Child 객체 생성
     * Child 객체를 Parent 타입으로 형 변환 : 업 캐스팅
     * Child 객체 -> Parent 타입 객체 -> Child 타입 형 변환 : 다운 캐스팅
     */
    public static void main(String[] args) {
        /**
         * Child 객체 생성
         */
        System.out.println("[1] Child 객체 생성");
        Child c1 = new Child();
        System.out.println(c1.field1); // 자식필드 없음 - 부모필드 값
        System.out.println(c1.field2); // 자식필드 값
        System.out.println(c1.field3); // 자식필드 값

        c1.method1("1"); // 자식함수 Override
        c1.method2("2"); // 자식함수 없음 - 부모함수 호출
        c1.method3(); // 자식함수 호출
        System.out.println();

        /**
         * Child 객체를 Parent 타입으로 형 변환 : 업캐스팅
         */
        System.out.println("[2] Child 객체를 Parent 타입으로 형 변환 : 업캐스팅");
        Parent c21 = c1; // 자식에서 부모로 형 변환
        System.out.println(c21.field1); // 부모필드 값
        System.out.println(c21.field2); // 부모필드 값
        // System.out.println(c21.field3); // 부모필드 없음
        c21.method1("1"); // 재정의는 로직을 덮어씀, 자식함수 로직호출
        c21.method2("2"); // 부모함수 호출
        System.out.println();

        /**
         * Child 객체 -> Parent 타입 객체 -> Child 타입 형변환 : 타입 캐스팅
         */
        System.out.println("[3] Child 객체 -> Parenrt 타입 객체 -> Child 타입 형변환 : 다운캐스팅");
        Child c22 = (Child) c21; // Parent -> Child 형변환
        System.out.println(c22.field1); // 자식필드 없음 - 부모필드값
        System.out.println(c22.field2); // 자식필드값
        System.out.println(c22.field3); // 자식필드값
        c22.method1("1"); // 재정의 된 자식함수 호출
        c22.method2("2"); // 자식함수 없음 -> 부모함수 호출
        c22.method3(); // 자식함수 호출
    }
}