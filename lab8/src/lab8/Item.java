package lab8;

/**
 * клас предмета
 */
public class Item {

    /**
     * ім'я
     */
    private String name;

    /**
     * встановлює ім'я
     *
     * @param name ім'я
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * повертає ім'я
     *
     * @return ім'я
     */
    public String getName() {
        return name;
    }
}
