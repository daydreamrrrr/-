package lab13;

import java.util.Scanner;
import lab13.Weapons.ActionBattle;

/**
 * клас битви
 */
public class Battle implements Attack{

    Scanner sc = new Scanner(System.in);
    private final String answer1 = ("Ворогу вдалося вас вдарити...");
    private final String answer2 = ("Ворог промахнувся!");
    private final String answer3 = ("Ви влучили у ворога!");
    private final String answer4 = ("Ви промахнулися...");
    private final String answer5 = ("Ви перемогли ворога!");
    private final String answer6 = ("Ворог переміг вас...");
/**
 * метод бою
 * @param player_hp здоров'я гравця
 * @param enemy_hp здоров'я ворога
 * @param enemy_damage урон ворога
 * @param player_damage урон гравця
 * @param weapon зброя
 * @return перемога або поразка
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
            System.out.println("=================== Битва =====================");
            System.out.println("Ваше здоров'я: " + player_hp);
            System.out.println("Ваша зброя: " + weapon.getName());
            System.out.println("Урон: " + weapon.getDamage());
            System.out.println("===============================================");
            System.out.println("Здоров'я ворога: " + enemy_hp);
            System.out.println("================== Ваші дії ===================");
            System.out.println(ActionBattle.getAction1() + " (Урон: " + (weapon.getDamage() - 10) + " Успішність: " + (weapon.getChance() - 10) + ")");
            System.out.println(ActionBattle.getAction2() + " (Урон: " + weapon.getDamage() + " (Успішність: " + (weapon.getChance() + 20) + ")");
            System.out.println(ActionBattle.getAction3() + " (Урон: " + (weapon.getDamage() + 30) + " (Успішність: " + (weapon.getChance() + 50) + ")");
            System.out.println("===============================================");
            System.out.print("Ваші дії: ");
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
