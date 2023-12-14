package lab7;

import java.util.Scanner;
import employees.Manager;
import employees.developers.Frontend;
import employees.developers.Fullstack;
import employees.developers.Backend;

/**
 * Головний клас програми
 */
public class Lab7 {

    /**
     * Метод main
     *
     * @param args рядки
     */
    public static void main(String[] args) {
        /**
         * Екземпляр класу Scanner
         */
        Scanner s = new Scanner(System.in);
        /**
         * Вибір користувача
         */
        int choice;
        do {
            System.out.println("Оберіть вид працівника:");
            System.out.println("Розробник (1)");
            System.out.println("Менеджер (2)");
            System.out.println("Вихід (0)");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    handleDeveloperMenu(s);
                    break;
                case 2:
                    /**
                     * Екземпляр класу Manager
                     */
                    Manager manager = new Manager("Олена", 2000);
                    manager.printSalary();
                    break;
                case 0:
                    System.out.println("Програма завершила роботу.");
                    break;
                default:
                    System.out.println("Неправильний ввід, спробуйте знову.");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * Внутрішнє меню
     *
     * @param s сканер
     */
    private static void handleDeveloperMenu(Scanner s) {
        /**
         * Вибір користувача
         */
        int devChoice;
        do {
            System.out.println("Оберіть вид розробника:");
            System.out.println("Backend Developer (1)");
            System.out.println("Frontend Developer (2)");
            System.out.println("Fullstack Developer (3)");
            System.out.println("Назад (0)");
            devChoice = s.nextInt();
            switch (devChoice) {
                case 1:
                    /**
                     * Екземпляр класу Backend
                     */
                    Backend backend = new Backend("Іван", 2000, "Java");
                    backend.printSalary();
                    backend.printSkill();
                    break;
                case 2:
                    /**
                     * Екземпляр класу Frontend
                     */
                    Frontend frontend = new Frontend("Петро", 2000, "JavaScript");
                    frontend.printSalary();
                    frontend.printSkill();
                    break;
                case 3:
                    /**
                     * Екземпляр класу Fullstack
                     */
                    Fullstack fullstack = new Fullstack("Олег", 2000, "Java, JavaScript");
                    fullstack.printSalary();
                    fullstack.printSkill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неправильний ввід, спробуйте знову.");
                    break;
            }
        } while (devChoice != 0);
    }
}
