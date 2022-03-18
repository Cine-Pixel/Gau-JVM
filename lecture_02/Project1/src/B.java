import java.util.Scanner;

public class B {
    public int a, b, c;

    public void method1() {
        Scanner sr = new Scanner(System.in);
        a = sr.nextInt();
        b = sr.nextInt();
        c = sr.nextInt();
    }

    public void method2() {
        int max;
        if( a > b && a > c) {
            max = a;
        } else if (b > a && b > c) {
            max = b;
        } else {
            max = c;
        }
        System.out.println(max);
    }

    public int method3() {
        int min;
        if( a < b && a < c) {
            min = a;
        } else if (b < a && b < c) {
            min = b;
        } else {
            min = c;
        }
        return min;
    }
}
