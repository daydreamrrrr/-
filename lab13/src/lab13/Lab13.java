package lab13;

import java.util.Scanner;

public class Lab13 {
/**
 * ����� Main
 */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("================= ������� ���� ================");
        System.out.println(" (1) ������ ���");
        System.out.println("===============================================");
        System.out.println(" (0) ����� � ���");
        System.out.println("===============================================");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                Location1 loc1 = new Location1();
                loc1.start();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("������������ ���. ��������� �����.");
                break;
        }
    }

}
