package ch10.part01.main7;

public class TestMain {

    // exec() 함수 정의 - MyException 예외타입을 이용한 예외처리 위임하기
    public static void exec(int typeCode) throws MyException {

        if (typeCode < 0) {
            // typeCode 범위 초과 시 고의 예외발생처리
            throw new MyException("타입코드는 0이상의 값이 입력되어야 합니다");
        }

        // 메인로직 처리하기
        System.out.println("메인로직 처리");
    }

    public static void main(String[] args) {
        // case1. 정상 - typeCode 에러없음
        int typeCode = -1;

        // case2. 예외발생 - typeCode 범위초과
        // typeCode = -1;

        // exec() 함수 사용 - try - catch - finally 블록으로 예외 직접처리
        try {
            TestMain.exec(typeCode);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}