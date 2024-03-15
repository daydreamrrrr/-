package lab11.payment;

/**
 * клас оплати карткою через nfc
 */
public class NFC implements Switch, Payment {

    /**
     * наявність підключення
     */
    private boolean connected = false;

    /**
     * увімкнення
     */
    @Override
    public void enable() {
        System.out.println("NFC увімкнено.");
        connected = true;
    }

    /**
     * вимкнення
     */
    @Override
    public void disable() {
        System.out.println("NFC вимкнено.");
        connected = false;
    }

    /**
     * оплата через nfc
     *
     * @param amount сума оплати
     */
    @Override
    public void pay(double amount) {
        if (!connected) {
            System.out.println("Прикладіть картку, будь ласка.");

        } else if (amount <= Card.balance) {
            Card.balance -= amount;
            System.out.println("Операція успішна. Баланс: " + Card.balance);

        } else {
            System.out.println("Недостатньо коштів.");

        }
    }

}
