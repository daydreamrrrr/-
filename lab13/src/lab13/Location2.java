package lab13;

/**
 * ���� ������� 2
 */
public class Location2 extends Location {

    /**
     * ������� ������� 2F
     */
    @Override
    public void start() {
        System.out.println("� ����� ������� �� ��������� ����. ��� � ��� � ����� �����,\n"
                + "� ��, ���������� ��������, ������� ��� � �����������.\n\n"
                + "�� ���� � ����������� �� ������ ���� � ���������.");
        Battle battle = new Battle();
        Weapons weapons = new Weapons();
        Weapons.Ranged submachineGun = weapons.new Ranged("ϳ������-�������", 30, 40);
        if (battle.fight(200, 100, 40, submachineGun.getDamage(), submachineGun) == true) {
            Location3 loc3 = new Location3();
            loc3.start();
        } else {
            end();
        }
    }
}
