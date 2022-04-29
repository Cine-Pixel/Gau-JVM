package task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    /*
     * დაწერეთ პროგრამა, რომლის საშუალებითაც numbers.txt ფაილში ჩაიწერება
     * შემთხვევით n ცალი მთელი რიცხვი [-12; 23] შუალედიდან, n-ის შეტანა მოახდინეთ
     * კლავიატურიდან.
     * წაიკითხეთ numberts.txt ფაილი და დაბეჭდეთ რიცხვების ჯამი.
     */
    public Task2() {
        this.CreateFile();
        this.ReadFile();
    }

    private void CreateFile() {
        int n;
        Scanner sr = new Scanner(System.in);
        Random random = new Random();
        n = sr.nextInt();
        try {
            FileOutputStream stream = new FileOutputStream("./numbers.txt");
            for (int i = 0; i < n; i++) {
                int num = random.nextInt(-12, 23 + 1);
                String a = Integer.toString(num);
                a = a + ' ';
                stream.write(a.getBytes());
            }
            stream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void ReadFile() {
        try {
            Scanner scanner = new Scanner(new File("./numbers.txt"));
            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
