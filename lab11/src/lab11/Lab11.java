package lab11;

import java.util.Scanner;
import lab11.payment.NFC;
import lab11.payment.Card;
import java.util.regex.Pattern;

/**
 * головний клас програми
 */
public class Lab11 {

    /**
     * сканер
     */
    private static final Scanner s = new Scanner(System.in);
    /**
     * патерни для перевірки вводу
     */
    private static final Pattern amountpattern1 = Pattern.compile("\\d+\\.\\d{2}");
    private static final Pattern amountpattern2 = Pattern.compile("[1-9]\\d*");

    /**
     * метод main з меню
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * екземпляр класу картки
         */
        Card card = new Card();
        /**
         * екземпляр класу NFC
         */
        NFC nfc = new NFC();
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Сплатити фізичною карткою");
            System.out.println("2. Увімкнути NFC");
            System.out.println("3. Вимкнути NFC");
            System.out.println("4. Сплатити через NFC");
            System.out.println("0. Вийти");
            System.out.print("Виберіть опцію: ");
            int choice = readChoice();
            switch (choice) {
                case 1:
                    System.out.print("Сума оплати: ");
                    double amount = readAmount();
                    card.pay(amount);
                    break;
                case 2:
                    nfc.enable();
                    break;
                case 3:
                    nfc.disable();
                    break;
                case 4:
                    System.out.print("Сума оплати: ");
                    amount = readAmount();
                    nfc.pay(amount);
                    break;
                case 0:
                    System.out.println("Вихід.");
                    return;
                default:
                    System.out.println("Неправильний ввід. Спробуйте знову.");
            }
        }
    }

    private static double readAmount() {
        while (true) {
            String input = s.next();
            if (amountpattern1.matcher(input).matches() || amountpattern2.matcher(input).matches()) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Неправильний ввід. Спробуйте знову.");
            }
        }
    }

    private static int readChoice() {
        while (true) {
            String input = s.next();
            if (amountpattern2.matcher(input).matches()) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Неправильний ввід. Спробуйте знову.");
            }
        }
    }
}
