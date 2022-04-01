import java.util.Random;
import java.util.Scanner;

public class App {
    public static boolean is_prime(int x) {
        int divisors = 2;
        for(int p=2; p < x; p++) {
            if(x % p == 0) divisors++;
        }
        return divisors == 2;
    }

    public static void main(String[] args) throws Exception {
        // task 1
        C class1 = new C();
        class1.method1();
        class1.method2();
        class1.method3();
        class1.method4();

        // task 2
        A class2 = new A();
        class2.method1();
        class2.method2();
        class2.method3();

        // task 3
        B class3 = new B(4, 10);
        class3.method1();
        class3.method2();

        // task 4
        Scanner sr = new Scanner(System.in);
        int a = sr.nextInt();
        int b = sr.nextInt();
        sr.close();

        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        Random rn = new Random();
        int prime_count = 0;
        for(int i=0; i < 20; i++) {
            int num = rn.nextInt(a, b);
            if(App.is_prime(num))
                prime_count++;
        }
        System.out.println("მარიტივია " + prime_count);
    }
}
