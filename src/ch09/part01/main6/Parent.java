package ch09.part01.main6;

public class Parent {
    /**
     * field1, field2 전역변수 정의
     * method1() 함수 정의
     * method2() 함수 정의
     */
    public String field1 = "field1-Parent";
    public String field2 = "field2-Parent";

    /**
     * method1() 함수 정의
     */
    public void method1(String msg){
        System.out.println(msg+"\t부모함수 method1()");
    }

    /**
     * method2() 함수 정의
     */
    public void method2(String msg){
        System.out.println(msg+"\t부모함수 method2()");
    }
}
