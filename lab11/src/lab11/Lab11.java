package lab11;

import java.util.Scanner;
import lab11.payment.NFC;
import lab11.payment.Card;

/**
 * �������� ���� ��������
 */
public class Lab11 {

    /**
     * ����� main � ����
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * ������
         */
        Scanner s = new Scanner(System.in);
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
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("���� ������: ");
                    /**
                     * ������� ���� ������
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
                    System.out.print("���� ������: ");
                    sum = s.nextInt();
                    nfc.pay(sum);
                    break;
                case 0:
                    System.out.println("�����.");
                    return;
                default:
                    System.out.println("������������ ���. ��������� �����.");
            }
        }

    }
}
