package task1;

import java.util.Scanner;

public class A {
    public int x;

    public A() {
        System.out.println("hello My A Class");
    }

    public void ParentMethod1() {
        Scanner sr = new Scanner(System.in);
        x = sr.nextInt();
    }

    public void ParentMethod2() {
        System.out.println(x);
    }

    public String method3() {
        if(x%2 == 0) {
            return "Even";
        }
        return "Odd";
    }
}
