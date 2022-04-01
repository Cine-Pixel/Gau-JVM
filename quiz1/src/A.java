import java.util.Random;

public class A {
    protected int x;        

    public A() {
        System.out.println("Hello A Class");
    }

    public void method1() {
        Random rn = new Random();
        x = rn.nextInt(100);
    }

    public void method2() {
        System.out.println(x - 1);
    }

    public void method3() {
        int divisors = 2;
        for(int p=2; p < x; p++) {
            if(x % p == 0) divisors++;
        }

        if(divisors == 2) {
            System.out.println("მარტივი რიცხვი");
        } else {
            System.out.println("შედგენილი რიცხვი");
        }
    }
}
