package task3;

import java.util.Random;

public class SubtractNumber extends Thread {
    /*
     * განსაზღვრეთ კლასი SubtractNumber, PrimaryNumber ცვლადით. დაწერეთ
     * SubtractNumber კონსტრუქტორი, რომელიც უზრუნველყოფს PrimeryNumber ცვლადის
     * ინიციალიზაციას.
     */
    public PrimaryNumber number;

    public SubtractNumber(PrimaryNumber number) {
        this.number = number;
    }

    /*
     * დაწერეთ მეთოდი, რომელიც PrimeryNumber ობიექტის number ცვლადს
     * ამცირებს შემთხვევითი რიცხვით [50; 60] შუალედიდან, იმ შემთხვევაში თუ
     * number ცვლადის მნიშვნელობა მეტია ან ტოლი 60-ის.
     */
    public void RandomSubraction() {
        Random random = new Random();
        int old_num = this.number.getNumber();
        if (old_num >= 60) {
            int new_num = this.number.getNumber() - random.nextInt(50, 60 + 1);
            this.number.setNumber(new_num);
            System.out.println(new_num);
        }
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            RandomSubraction();
    }
}
