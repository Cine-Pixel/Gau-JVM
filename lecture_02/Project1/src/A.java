import java.util.Scanner;

public class A {
    public int a, b;

    public void method1() {
        Scanner sr = new Scanner(System.in);
        a = sr.nextInt();
        b = sr.nextInt();
    }

    public void method2() {
        System.out.println(a + b);
    }
    
    public int method3() {
        return a * b;
    }
}
