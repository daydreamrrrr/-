package lab13;

/**
 * ���� ������� 3
 */
public class Location3 extends Location {

    /**
     * ������� ������� 3
     */
    @Override
    public void start() {
        System.out.println("�������� � �����������, �� ���������� � ��������� �� ������ ��������.\n"
                + "�� ��������� �� ����� � ����� � ������ ������������ ����, ����� �� ����-������ ������.\n\n"
                + "�� ��������� ��������.");
        Battle battle = new Battle();
        Weapons weapons = new Weapons();
        Weapons.Ranged rifle = weapons.new Ranged("��������", 50, 50);
        if (battle.fight(200, 200, 50, rifle.getDamage(), rifle) == true) {
            System.out.println("�� ������ ��� � ����� ������.");
            System.exit(0);
        } else {
            end();
        }
    }
}
