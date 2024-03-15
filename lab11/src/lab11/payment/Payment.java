package lab11.payment;

/**
 * інтерфейс оплати
 */
public interface Payment {

    /**
     * метод оплати
     *
     * @param amount сума оплати
     */
    void pay(double amount);
}
