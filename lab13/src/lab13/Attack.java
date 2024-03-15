package lab13;
/**
 * інтерфейс атаки
 */
public interface Attack {
/**
 * метод атаки
 * @param chance шанс
 * @param damage урон
 * @param hp здоров'я
 * @param answer1 відповідь, якщо удар вдався
 * @param answer2 відповідь, якщо удар не вдався
 * @return здоров'я
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
