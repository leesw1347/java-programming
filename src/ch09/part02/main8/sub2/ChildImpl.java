package ch09.part02.main8.sub2;

public class ChildImpl implements IParent {
    @Override
    public void method1() {
        System.out.println("\tChildImpl method1() 함수 재정의");
    }

    @Override
    public void method2() {
//        IParent.super.method2();
        System.out.println("\tChildImpl method2() 함수 재정의");
    }

    public void method4() {
//        IParent.super.method3();
        System.out.println("\tChildImpl method4() 함수 정의");
    }
}
