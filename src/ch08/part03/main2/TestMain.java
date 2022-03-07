package ch08.part03.main2;

public class TestMain {
    public static int factorial(int a) {
        if (a < 0) {
            return -1;
        }
        if (a == 0 || a == 1) {
            return 1;
        }
        int value = a * factorial(a - 1);
        System.out.println("\t" + a + " factorial(" + (a - 1) + ")");
        return value;
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }
}