import java.util.Scanner;

public class B extends A {
    private int y;

    public B(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public void method1() {
        Scanner sr = new Scanner(System.in);
        this.y = sr.nextInt();
        sr.close();
    }

    public int method2_child() {
        return this.x + 2*this.y;
    }
}
