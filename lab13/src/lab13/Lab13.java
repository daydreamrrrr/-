package lab13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab13 {

    /**
     * ����� Main
     */
    private static final Scanner s = new Scanner(System.in);
    private static final Pattern choicePattern = Pattern.compile("[1-9]\\d*");

    public static void main(String[] args) {
        System.out.println("================= ������� ���� ================");
        System.out.println(" (1) ������ ���");
        System.out.println("===============================================");
        System.out.println(" (0) ����� � ���");
        System.out.println("===============================================");
        int choice = readChoice();
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

    private static int readChoice() {
        while (true) {
            String input = s.next();
            if (choicePattern.matcher(input).matches()) {
                return Integer.parseInt(input);
            } else {
                System.out.println("������������ ���. ��������� �����.");
            }
        }
    }
}
