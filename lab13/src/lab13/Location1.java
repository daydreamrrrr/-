package lab13;

/**
 * ���� ������� 1
 */
public class Location1 extends Location {

    /**
     * ������� ������� 1
     */
    @Override
    public void start() {
        System.out.println("� 2085 ���� ������ ���� ����������. �� ������ � ���� �� �����.\n"
                + "ĳ������ �� ��������, �� ������, �� ������ ������, � �� ��� �����\n"
                + "���� � �������. � ��� � ������ ��������� � ���������� ������� �������.");
        Battle battle = new Battle();
        Weapons weapons = new Weapons();
        Weapons.Ranged revolver = weapons.new Ranged("���������", 20, 30);
        if (battle.fight(200, 50, 15, revolver.getDamage(), revolver) == true) {
            System.out.println("�� ���� �� �����. �������� � �������, �� ������� �"
                    + "\n������ ��������� ������ �������-�������.");
            Location2 loc2 = new Location2();
            loc2.start();
        } else {
            end();
        }
    }
}
