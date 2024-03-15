package lab11.payment;

/**
 * клас оплати фізичною карткою
 */
public class Card implements Payment {

    /**
     * баланс на карті
     */
    static double balance = 1000;

    /**
     * інтерфейс оплати
     *
     * @param amount сума оплати
     */
    @Override
    public void pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Операція успішна. Баланс: " + balance);
        } else {
            System.out.println("Недостатньо коштів.");
        }
    }

}
