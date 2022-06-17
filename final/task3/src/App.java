import java.io.FileOutputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * დაწერეთ პროგრამა, რომელიც file.txt ფაილში ჩაწერს შეტანილი ორნიშნა რიცხვის
         * ციფრებით შედგენილ ნებისმიერ ერთნიშნა ან ორნიშნა რიცხვებს.
         */
        Scanner sr = new Scanner(System.in);

        int num = sr.nextInt();
        if (num < 10 || num > 99) {
            System.out.println("შეიყვანეთ ორნიშნა რიცხვი");
        } else {
            try {
                FileOutputStream stream = new FileOutputStream("./file.txt");
                int second_digit = num % 10;
                int first_digit = num / 10;
                String res = "" + first_digit + " " + second_digit + " " + (first_digit * 10 + second_digit) + " "
                        + (second_digit * 10 + first_digit);
                stream.write(res.getBytes());
                stream.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        sr.close();
    }
}
