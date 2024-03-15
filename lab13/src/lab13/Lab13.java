package lab13;

import java.util.Scanner;

public class Lab13 {
/**
 * метод Main
 */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("================= Головне меню ================");
        System.out.println(" (1) Почати гру");
        System.out.println("===============================================");
        System.out.println(" (0) Вийти з гри");
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
                System.out.println("Неправильний ввід. Спробуйте знову.");
                break;
        }
    }

}
