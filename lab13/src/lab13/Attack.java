package lab13;
/**
 * ��������� �����
 */
public interface Attack {
/**
 * ����� �����
 * @param chance ����
 * @param damage ����
 * @param hp ������'�
 * @param answer1 �������, ���� ���� ������
 * @param answer2 �������, ���� ���� �� ������
 * @return ������'�
 */
    default int attack(int chance, int damage, int hp, String answer1, String answer2) {
        double dice = Math.random() * 100;
        if (dice <= chance) {
            System.out.println(answer1);
            return hp - damage;
        } else {
            System.out.println(answer2);
            return hp;
        }
    }
}
