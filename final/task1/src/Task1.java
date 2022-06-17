import java.util.ArrayList;
import java.util.Random;

public class Task1 implements ITask1 {
    /*
     * განსაზღვრეთ კლასი: კოლექციით; მეთოდებით; მეთოდებისთვის გამოიყენეთ
     * ინტერფეისი.
     */
    private ArrayList<String> random_strings = new ArrayList<String>();

    private String getRandomString(int length, String alphabet) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(0, alphabet.length());
            sb.append(alphabet.charAt(index));
        }

        return sb.toString();
    }

    @Override
    public void method1() {
        /*
         * მეთოდი 1: კოლექციაში ჩაწერს 20 შემთხვევით 7 სიმბოლოან სტრიქონს, თითოული
         * სტრიქონი შედგება განსხვავებული სიმბოლოებისგან;
         */
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 20; i++) {
            String str = this.getRandomString(7, alphabet);
            random_strings.add(str);
        }
    }

    @Override
    public void method2() {
        /*
         * მეთოდი 2: შეცვლის კოლექციაში იმ სტრიქონებს, რომელიც შეიცავს სიმბოლო a-ს,
         * შემთხვევითი 5 სიმბოლოიანი სტრიქონით, რომელიც არ შეიცავს სიმბოლო a-ს;
         */
        String alphabet = "bcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < random_strings.size(); i++) {
            if (random_strings.get(i).contains("a")) {
                random_strings.set(i, this.getRandomString(5, alphabet));
            }
        }
    }

    @Override
    public void method3() {
        /*
         * მეთოდი 3: ჩაამატებს კოლექციაში შემთხვევითად აღებული ინდექსის შემდეგ 5
         * შემთხვევით მხოლოდ ციფრებისგან შემდგარ 4 სიმბოლოიან სტრიქონს;
         */
        String alphabet = "0123456789";
        Random random = new Random();
        int index = random.nextInt(0, random_strings.size());
        int size = random_strings.size();
        for (int i = 0; i < size; i++) {
            random_strings.add(index, this.getRandomString(4, alphabet));
        }
    }

    @Override
    public void method4() {
        /* მეთოდი 4: ბეჭდავს კოლექციას. */
        for (String str : random_strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}