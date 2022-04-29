import task1.Task1;
import task2.Task2;
import task3.PrimaryNumber;
import task3.SubtractNumber;

public class App {
    public static void main(String[] args) throws Exception {
        // Task 1
        Task1 task1 = new Task1();
        System.out.println("Task 1 method 1");
        task1.Method1();

        System.out.println("Task 1 method 2");
        task1.Method2();

        System.out.println("Task 1 method 3");
        System.out.println(task1.Method3());

        System.out.println("Task 1 method 4");
        task1.Method4();

        System.out.println("Task 1 method 5");
        task1.Method5();

        // Task 2
        System.out.println("\n\nTask 2");
        new Task2();

        // Task 3
        PrimaryNumber number = new PrimaryNumber();
        number.setRanomNumber();

        SubtractNumber sn1 = new SubtractNumber(number);
        Thread t1 = new Thread(sn1);
        t1.run();

        SubtractNumber sn2 = new SubtractNumber(number);
        Thread t2 = new Thread(sn2);
        t2.run();
    }
}
