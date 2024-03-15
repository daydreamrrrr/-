package lab13;

import java.util.Scanner;
import lab13.Weapons.ActionBattle;

/**
 * ���� �����
 */
public class Battle implements Attack{

    Scanner sc = new Scanner(System.in);
    private final String answer1 = ("������ ������� ��� �������...");
    private final String answer2 = ("����� �����������!");
    private final String answer3 = ("�� ������� � ������!");
    private final String answer4 = ("�� ������������...");
    private final String answer5 = ("�� ��������� ������!");
    private final String answer6 = ("����� ������ ���...");
/**
 * ����� ���
 * @param player_hp ������'� ������
 * @param enemy_hp ������'� ������
 * @param enemy_damage ���� ������
 * @param player_damage ���� ������
 * @param weapon �����
 * @return �������� ��� �������
 */
    public boolean fight(int player_hp, int enemy_hp, int enemy_damage, int player_damage, Weapons.Ranged weapon) {
        int action;
        while (player_hp != 0 || enemy_hp != 0) {
            if (enemy_hp <= 0) {
                System.out.println(answer5);
                return true;
            } else if (player_hp <= 0) {
                System.out.println(answer6);
                return false;
            }
            System.out.println("=================== ����� =====================");
            System.out.println("���� ������'�: " + player_hp);
            System.out.println("���� �����: " + weapon.getName());
            System.out.println("����: " + weapon.getDamage());
            System.out.println("===============================================");
            System.out.println("������'� ������: " + enemy_hp);
            System.out.println("================== ���� 䳿 ===================");
            System.out.println(ActionBattle.getAction1() + " (����: " + (weapon.getDamage() - 10) + " ��������: " + (weapon.getChance() - 10) + ")");
            System.out.println(ActionBattle.getAction2() + " (����: " + weapon.getDamage() + " (��������: " + (weapon.getChance() + 20) + ")");
            System.out.println(ActionBattle.getAction3() + " (����: " + (weapon.getDamage() + 30) + " (��������: " + (weapon.getChance() + 50) + ")");
            System.out.println("===============================================");
            System.out.print("���� 䳿: ");
            action = sc.nextInt();
            System.out.println();
            switch (action) {
                case 1 ->
                    enemy_hp = attack(weapon.getChance() - 10, weapon.getDamage() + 40, enemy_hp, answer3, answer4);
                case 2 ->
                    enemy_hp = attack(weapon.getChance(), weapon.getDamage() + 20, enemy_hp, answer3, answer4);
                case 3 ->
                    enemy_hp = attack(weapon.getChance() + 30, weapon.getDamage() - 10, enemy_hp, answer3, answer4);
            }
            player_hp = attack(40, 30, player_hp, answer1, answer2);
        }
        return false;
    }
}
