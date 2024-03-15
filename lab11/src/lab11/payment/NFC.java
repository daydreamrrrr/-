package lab11.payment;

/**
 * ���� ������ ������� ����� nfc
 */
public class NFC implements Switch, Payment {

    /**
     * �������� ����������
     */
    private boolean connected = false;

    /**
     * ���������
     */
    @Override
    public void enable() {
        System.out.println("NFC ��������.");
        connected = true;
    }

    /**
     * ���������
     */
    @Override
    public void disable() {
        System.out.println("NFC ��������.");
        connected = false;
    }

    /**
     * ������ ����� nfc
     *
     * @param amount ���� ������
     */
    @Override
    public void pay(double amount) {
        if (!connected) {
            System.out.println("��������� ������, ���� �����.");

        } else if (amount <= Card.balance) {
            Card.balance -= amount;
            System.out.println("�������� ������. ������: " + Card.balance);

        } else {
            System.out.println("����������� �����.");

        }
    }

}
