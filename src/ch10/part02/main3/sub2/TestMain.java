package ch10.part02.main3.sub2;

public class TestMain {
    // static method1() 함수 정의, finally 미사용
    public static void method1() {
        boolean isSuccess = true;
        // try 블록
        try {
            System.out.println("\t method1 : 로직처리");
            if (isSuccess) {
                // try 블록 내 return 처리
                System.out.println("\t method1 : return 실행");
                return; // return 명령이 실행 후 함수 종료
            }
        }
        // catch 블록
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("\t method1: finally 필수처리로직"); // 실행안됨
    }

    // static method2() 함수 정의 - finally 사용
    public static void method2() {
        boolean isSuccess = true;
        // try 블록
        try {
            System.out.println("\t method2: 로직처리");

            if(isSuccess){
                System.out.println("\t method2 : return 실행");
                return; // return 명령이 실행되어도 finally 구문이 실행됨
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 필수로직처리
            System.out.println("\t method2 : finally 필수처리로직"); // 실행됨
        }
    }

    // 메인함수 정의
    public static void main(String[] args) {
        // method1() 함수 및 method2() 함수 사용
        System.out.println("method1() 함수 사용");
        TestMain.method1();
        TestMain.method2();
    }
}
