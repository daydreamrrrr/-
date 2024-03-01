package lab11.payment;

/**
 * ���� ������ �������� �������
 */
public class Card implements Payment {

    /**
     * ������ �� ����
     */
    static int balance = 1000;

    /**
     * ��������� ������
     *
     * @param amount ���� ������
     */
    @Override
    public void pay(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("�������� ������. ������: " + balance);
        } else {
            System.out.println("����������� �����.");
        }
    }

}
