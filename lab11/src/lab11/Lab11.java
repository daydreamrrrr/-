package lab11;

import java.util.Scanner;
import lab11.payment.NFC;
import lab11.payment.Card;
import java.util.regex.Pattern;

/**
 * �������� ���� ��������
 */
public class Lab11 {

    /**
     * ������
     */
    private static final Scanner s = new Scanner(System.in);
    /**
     * ������� ��� �������� �����
     */
    private static final Pattern amountpattern1 = Pattern.compile("\\d+\\.\\d{2}");
    private static final Pattern amountpattern2 = Pattern.compile("[1-9]\\d*");

    /**
     * ����� main � ����
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * ��������� ����� ������
         */
        Card card = new Card();
        /**
         * ��������� ����� NFC
         */
        NFC nfc = new NFC();
        while (true) {
            System.out.println("����:");
            System.out.println("1. �������� �������� �������");
            System.out.println("2. �������� NFC");
            System.out.println("3. �������� NFC");
            System.out.println("4. �������� ����� NFC");
            System.out.println("0. �����");
            System.out.print("������� �����: ");
            int choice = readChoice();
            switch (choice) {
                case 1:
                    System.out.print("���� ������: ");
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
                    System.out.print("���� ������: ");
                    amount = readAmount();
                    nfc.pay(amount);
                    break;
                case 0:
                    System.out.println("�����.");
                    return;
                default:
                    System.out.println("������������ ���. ��������� �����.");
            }
        }
    }

    private static double readAmount() {
        while (true) {
            String input = s.next();
            if (amountpattern1.matcher(input).matches() || amountpattern2.matcher(input).matches()) {
                return Double.parseDouble(input);
            } else {
                System.out.println("������������ ���. ��������� �����.");
            }
        }
    }

    private static int readChoice() {
        while (true) {
            String input = s.next();
            if (amountpattern2.matcher(input).matches()) {
                return Integer.parseInt(input);
            } else {
                System.out.println("������������ ���. ��������� �����.");
            }
        }
    }
}
