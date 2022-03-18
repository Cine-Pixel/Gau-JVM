import java.util.Scanner;

public class C {
    public int a, b, c;

    public void method1() {
        Scanner sr = new Scanner(System.in);
        a = sr.nextInt();
        b = sr.nextInt();
        c = sr.nextInt();
        sr.close();
    }

    public int method2() {
        return a % 10;
    }

    public int method3() {
        int b_local = b;

        while(b_local > 10) {
            b_local /= 10;
        }

        return b_local; 
    }

    public int method4() {
        int c_local = c;
        int sum = 0;

        while(c_local > 0) {
            sum += c_local%10;
            c_local /= 10;
        }
        return sum;
    }

    public void method5() {
        System.out.println(method2() * method3());
    }

    public void method6() {
        System.out.println(method3() + method4());
    }
}
