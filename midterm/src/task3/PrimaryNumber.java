package task3;

import java.io.FileOutputStream;
import java.util.Random;

public class PrimaryNumber {
    /*
     * განსაზღვრეთ კლასი PrimaryNumber, მთელი ტიპის დახური number ცვლადით.
     * დაწერეთ number ცვლადის მნიშვნელობის მინიჭებისა და მიღებისთვის საჭირო
     * მეთოდები.
     */
    private int number;

    // მიღების მეთოდი
    public int getNumber() {
        return this.number;
    }

    // მინიჭების მეთოდი
    public void setNumber(int number) {
        this.number = number;
        this.saveNumberInFile();
    }

    // დაწერეთ მეთოდი, რომელიც number ცლადს მიანიჭებს შემთხვევით მნიშვნელობას [100;
    // 200] შუალედიდან;
    public void setRanomNumber() {
        Random random = new Random();
        this.number = random.nextInt(100, 200 + 1);
    }

    // დაწერეთ მეთოდი, რომელიც შეინახავს number ცვლადის მნიშვნელობას number.txt
    // ფაილში მისი ყოველი ცვლილებისას.
    public void saveNumberInFile() {
        try {
            FileOutputStream stream = new FileOutputStream("./number.txt");
            stream.write(Integer.toString(this.number).getBytes());
            stream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
