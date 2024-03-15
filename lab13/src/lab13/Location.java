package lab13;

/**
 * абстрактний клас локації 
 */
public abstract class Location {

    /**
     * початок
     */
    public abstract void start();

    /**
     * кінець гри
     */
    public void end() {
        System.out.println("Ви померли.");
        System.out.println("Кінець гри.");
        System.exit(0);
    }
}
