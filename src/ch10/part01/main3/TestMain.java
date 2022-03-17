package ch10.part01.main3;

public class TestMain {
    // read() 함수 정의
    public void read() {
        try { // try 블록 - 업무로직 처리 구간
            // 리플렉션을 이용한 Class 타입 객체 생성
            // Class 타입을 이용하여, 객체 생성, 접근 및 설정, 함수 호출 등의 일을 할 수 있다
            Class<?> forName = Class.forName("ch10.part01.main3.ProductVo");

            // 리플렉션을 이용한 객체생성
            // Class 타입 객체를 이용하여 해당 객체 생성
            // 호출 시, 기본 생성자 함수를 이용하여 객체 생성한다
            // ProductVo 기본 생성자 함수가 없을 경우, InstantiationException 에러가 발생한다
            // 생성자 함수가 private 접근지정자로 막혀있을 경우, InstantiationException 에러가 발생한다
            ProductVo vo = (ProductVo) forName.newInstance();
            vo.setProductNo("a001");
            vo.setProductName("아메리카노");
            vo.setPrice(4000);

            System.out.println(forName);
            System.out.println(vo);

        } catch (ClassNotFoundException e) {
            // 메모리에 문자열로 된 클래스 정보가 없을 경우,  ClassNotFoundException 에러가 발생한다
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            System.out.println("마무리 구간 [로직생략가능]");
        }
    }

    // try 블록 - 업무처리 로직 구간
    //  리플렉션을 이용한 Class 타입 객체 생성
    //  리플렉션을 이용한 객체 생성

    // 메인함수 정의 - 객체생성 및 read() 함수 호출
    public static void main(String[] args) {
        TestMain main = new TestMain();
        main.read();
    }
}
