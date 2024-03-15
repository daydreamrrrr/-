package lab13;

/**
 * клас локації 2
 */
public class Location2 extends Location {

    /**
     * початок локації 2F
     */
    @Override
    public void start() {
        System.out.println("В цьому магазині не виявилося хліба. Але у вас є краща зброя,\n"
                + "і ви, набравшись сміливості, вирішуєте піти в супермаркет.\n\n"
                + "На вході в супермаркет ви бачите зомбі з арматурою.");
        Battle battle = new Battle();
        Weapons weapons = new Weapons();
        Weapons.Ranged submachineGun = weapons.new Ranged("Пістолет-кулемет", 30, 40);
        if (battle.fight(200, 100, 40, submachineGun.getDamage(), submachineGun) == true) {
            Location3 loc3 = new Location3();
            loc3.start();
        } else {
            end();
        }
    }
}
