package lab13;

/**
 * ����������� ���� ������� 
 */
public abstract class Location {

    /**
     * �������
     */
    public abstract void start();

    /**
     * ����� ���
     */
    public void end() {
        System.out.println("�� �������.");
        System.out.println("ʳ���� ���.");
        System.exit(0);
    }
}
