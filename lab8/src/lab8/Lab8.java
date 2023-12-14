package lab8;

import java.util.Scanner;

/**
 * головний клас програми
 */
public class Lab8 {

    /**
     * Метод main
     *
     * @param args рядки
     */
    public static void main(String[] args) {
        /**
         * Загальна кількість комірок
         */
        int totalCells = 150;
        /**
         * Кількість рядків
         */
        int rows = 15;
        /**
         * Кількісь стовпчиків
         */
        int columns = 10;
        StorageCamera camera = new StorageCamera(rows, columns);
        /**
         * сканер
         */
        Scanner s = new Scanner(System.in);
        while (totalCells > 0) {
            System.out.println("\nЗалишилось комірок для заповнення: " + totalCells);
            System.out.println("1. Зберегти предмет у комірці");
            System.out.println("2. Переглянути та вилучити предмет з комірки");
            System.out.println("Оберіть дію (1 або 2):");
            /**
             * вибір користувача
             */
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Введіть номер рядка (від 1 до " + rows + "):");
                    /**
                     * номер рядка
                     */
                    int row = s.nextInt() - 1;
                    System.out.println("Введіть номер стовпчика (від 1 до " + columns + "):");
                    /**
                     * номер стовпчика
                     */
                    int column = s.nextInt() - 1;
                    s.nextLine();
                    System.out.println("Введіть назву предмету для збереження в комірці:");
                    /**
                     * ім'я
                     */
                    String itemName = s.nextLine();
                    Item item = new Item(itemName);
                    try {
                        camera.storeItem(row, column, item);
                        totalCells--;
                    } catch (StorageException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Введіть номер рядка (від 1 до " + rows + "):");
                    int row = s.nextInt() - 1;
                    System.out.println("Введіть номер стовпчика (від 1 до " + columns + "):");
                    int column = s.nextInt() - 1;
                    try {
                        /**
                         * Екземпляр класу Item
                         */
                        Item retrievedItem = camera.retrieveItem(row, column);
                        System.out.println("Отриманий предмет з комірки " + (row + 1) + "-" + (column + 1) + ": " + retrievedItem.getName());
                        totalCells++;
                    } catch (StorageException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;
                }
                default:
                    System.out.println("Неправильний вибір. Виберіть 1 або 2.");
                    break;
            }
        }
        System.out.println("Всі комірки заповнені.");
        s.close();
    }

}
