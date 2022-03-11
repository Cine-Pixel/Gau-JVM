import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void task1() {
        System.out.println("C++");
        System.out.println("C#");
        System.out.println("Java");
        System.out.println("Pascal");
        System.out.println("PHP");
        System.out.println("Javascript");
        System.out.println("ActionScript");
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        int n1, n2;
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();

        System.out.println(n1 + " / " + n2 + " = " + n1 / n2);
        System.out.println(n2 + " % " + n1 + " = " + n2 % n1);

        scanner.close();
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);

        int n1, n2, n3;
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        n3 = scanner.nextInt();

        System.out.println("Sum: " + (n1 + n2 + n3));
        System.out.println("Product: " + n1 * n2 * n3);

        scanner.close();
    }

    public static void task6() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }

        System.out.printf("sum of digits: " + sum);

        scanner.close();
    }

    private static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        System.out.println("GCD: " + gcd(n1, n2));
        System.out.println("LMC: " + n1*n2/gcd(n1, n2));

        scanner.close();
    }

    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        for(int i=m; i<n; i++) {
            System.out.print(i + " ");
        }

        scanner.close();
    }

    public static void task9() {
        Random rd = new Random();
        double[] arr = new double[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextDouble();
            System.out.print(arr[i] + ' ');
        }
        System.out.println();
        System.out.println("max: " + Arrays.stream(arr).max().getAsDouble());
        System.out.println("min: " + Arrays.stream(arr).min().getAsDouble());
    }

    public static void task12() {
        Random rd = new Random();
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
            System.out.print(arr[i] + ' ');
        }
        System.out.println();

        Arrays.sort(arr);
        System.out.println(arr.toString());
    }

    public static void main(String[] args) throws Exception {
        // task1();
        // task2();
        // task3();
        // task6();
        // task7();
        // task8();
        // task9();
        task12();
    }
}
