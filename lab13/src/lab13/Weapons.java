package lab13;

/**
 * ���� ����
 */
public class Weapons {

    /**
     * ���� ���� ��������� ���
     */
    public class Ranged {

        /**
         * ����
         */
        private final int damage;
        /**
         * �����
         */
        private final String name;
        /**
         * ���� - ��������� ��������
         */
        private final int chance;

        public Ranged(String name, int damage, int chance) {
            this.name = name;
            this.damage = damage;
            this.chance = chance;
        }

        /**
         * ������ ��� ��'�
         *
         * @return ��'�
         */
        public String getName() {
            return name;
        }

        /**
         * ������ ��� �����
         *
         * @return ����
         */
        public int getDamage() {
            return damage;
        }

        /**
         * ������ ��� �����
         *
         * @return ����
         */
        public int getChance() {
            return chance;
        }
    }

    /**
     * 䳿 ������
     */
    static class ActionBattle {

        /**
         * �� 1
         *
         * @return ���� 䳿 1
         */
        public static String getAction1() {
            return "(1) ������ �������";
        }

        /**
         * �� 2
         *
         * @return ���� 䳿 2
         */
        public static String getAction2() {
            return "(2) �������� �������";
        }

        /**
         * �� 3
         *
         * @return ���� 䳿 3
         */
        public static String getAction3() {
            return "(3) ���������� ������";
        }
    }
}
