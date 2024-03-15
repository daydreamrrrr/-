package lab13;

/**
 * клас зброї
 */
public class Weapons {

    /**
     * клас зброї дальнього бою
     */
    public class Ranged {

        /**
         * урон
         */
        private final int damage;
        /**
         * назва
         */
        private final String name;
        /**
         * шанс - ймовірність влучання
         */
        private final int chance;

        public Ranged(String name, int damage, int chance) {
            this.name = name;
            this.damage = damage;
            this.chance = chance;
        }

        /**
         * геттер для ім'я
         *
         * @return ім'я
         */
        public String getName() {
            return name;
        }

        /**
         * геттер для урона
         *
         * @return урон
         */
        public int getDamage() {
            return damage;
        }

        /**
         * геттер для шансу
         *
         * @return шанс
         */
        public int getChance() {
            return chance;
        }
    }

    /**
     * дії гравця
     */
    static class ActionBattle {

        /**
         * дія 1
         *
         * @return опис дії 1
         */
        public static String getAction1() {
            return "(1) Швидка стрільба";
        }

        /**
         * дія 2
         *
         * @return опис дії 2
         */
        public static String getAction2() {
            return "(2) Звичайна стрільба";
        }

        /**
         * дія 3
         *
         * @return опис дії 3
         */
        public static String getAction3() {
            return "(3) Прицільний вогонь";
        }
    }
}
