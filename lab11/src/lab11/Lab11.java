package lab11;

import java.util.Scanner;
import lab11.payment.NFC;
import lab11.payment.Card;

/**
 * головний клас програми
 */
public class Lab11 {

    /**
     * метод main з меню
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * сканер
         */
        Scanner s = new Scanner(System.in);
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
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Сума оплати: ");
                    /**
                     * введена сума оплати
                     */
                    int sum = s.nextInt();
                    card.pay(sum);
                    break;
                case 2:
                    nfc.enable();
                    break;
                case 3:
                    nfc.disable();
                    break;
                case 4:
                    System.out.print("Сума оплати: ");
                    sum = s.nextInt();
                    nfc.pay(sum);
                    break;
                case 0:
                    System.out.println("Вихід.");
                    return;
                default:
                    System.out.println("Неправильний ввід. Спробуйте знову.");
            }
        }

    }
}
