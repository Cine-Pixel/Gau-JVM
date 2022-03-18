package task1;

import java.util.Scanner;

public class B extends A {
    public int y; 

    public void ChildMethod1() {
        Scanner sr = new Scanner(System.in);
        y = sr.nextInt();
    }

    public int ChildMethod2() {
        return this.x + this.y;
    }
}
