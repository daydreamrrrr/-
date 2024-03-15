package lab13;

/**
 * клас локації 3
 */
public class Location3 extends Location {

    /**
     * початок локації 3
     */
    @Override
    public void start() {
        System.out.println("Зайшовши в супермаркет, ви оглядуєтесь і знаходите між полиць гвинтівку.\n"
                + "Ви проходите до відділу з хлібом і бачите найсильнішого зомбі, якого ви коли-небудь бачили.\n\n"
                + "Ви заряджаєте гвинтівку.");
        Battle battle = new Battle();
        Weapons weapons = new Weapons();
        Weapons.Ranged rifle = weapons.new Ranged("Гвинтівка", 50, 50);
        if (battle.fight(200, 200, 50, rifle.getDamage(), rifle) == true) {
            System.out.println("Ви берете хліб і йдете додому.");
            System.exit(0);
        } else {
            end();
        }
    }
}
