import java.util.Scanner;

public class C {
    private int a, b;

    public void method1() {
        Scanner sr = new Scanner(System.in);

        a = sr.nextInt();
        b = sr.nextInt();
        sr.close();
    }

    public int method2() {
        int a_copy = a;

        int even_sum = 0;
        while (a_copy > 0){
            int digit = a_copy % 10;
            if (digit % 2 == 0) {
                even_sum += digit;
            }
            a_copy /= 10;
        }
        return even_sum;
    }

    public int method3() {
        int product = 1*b;
        for(int p=2; p < b; p++) {
            if(b % p == 0) product *= p;
        }
        return product;
    }

    public void method4() {
        System.out.println(this.method2() + this.method3());
    }
}
