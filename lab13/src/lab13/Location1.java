package lab13;

/**
 * клас локації 1
 */
public class Location1 extends Location {

    /**
     * початок локації 1
     */
    @Override
    public void start() {
        System.out.println("В 2085 році настав зомбі апокаліпсис. Ви вийшли з дому за хлібом.\n"
                + "Дійшовши до магазину, ви бачите, що вітрини розбиті, а на вас біжить\n"
                + "зомбі з палицею. У вас є старий револьвер і необмежена кількість патронів.");
        Battle battle = new Battle();
        Weapons weapons = new Weapons();
        Weapons.Ranged revolver = weapons.new Ranged("Револьвер", 20, 30);
        if (battle.fight(200, 50, 15, revolver.getDamage(), revolver) == true) {
            System.out.println("Це було не важко. Зайшовши в магазин, ви піднімаєте з"
                    + "\nпідлоги залишений кимось пістолет-кулемет.");
            Location2 loc2 = new Location2();
            loc2.start();
        } else {
            end();
        }
    }
}
