package task1;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    // განსაზღვრეთ კლასი: a და b მთელი ტიპის ცვლადებით, მთელი ტიპის m[12]
    // მასივით; მეთოდებით; პირველი ორი მეთოდისთვის გამოყენეთ ინტერფეისი.
    private int a;
    private int b;
    private int[] m = new int[12];

    // მეთოდი 1: ანიჭებს a და b-ს მნიშვნელობების კლავიატურიდან;
    public void Method1() {
        Scanner sr = new Scanner(System.in);
        a = sr.nextInt();
        b = sr.nextInt();
    }

    // მეთოდი 2: ანიჭებს m მასივის ელემენტებს შემთხვევით მნიშვნელობებს [a; b]
    // შუალედუდან;
    public void Method2() {
        for (int i = 0; i < m.length; i++) {
            Random rn = new Random();
            this.m[i] = rn.nextInt(this.a, this.b);
        }
    }

    // მეთოდი 3: აბრუნებს მასივის დადებითი ელემენტებიდან უმცირესს;
    public int Method3() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m.length; i++) {
            if (m[i] < min) {
                min = m[i];
            }
        }

        return min;
    }

    // მეთოდი 4: ბეჭდავს m მასივის ელემენტებს ინდექსები ჩვენებით;
    public void Method4() {
        for (int i = 0; i < m.length; i++) {
            System.out.print(i);
            System.out.print(" ");
            System.out.print(m[i]);
            System.out.println();
        }
    }

    // მეთოდი 5: ბეჭდავს მასივიდან 3-ის ჯერად რიცხვებს.
    public void Method5() {
        for (int i = 0; i < m.length; i++) {
            if (m[i] % 3 == 0) {
                System.out.println(m[i]);
            }
        }
    }
}
