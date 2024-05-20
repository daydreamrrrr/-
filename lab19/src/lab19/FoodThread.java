package lab19;

import javax.swing.JOptionPane;
import static lab19.MainFrame.LifeThread.setHungry;

public class FoodThread extends Thread {

    public void run() {
        try {
            setHungry(false);
            Thread.sleep(15000);
            JOptionPane.showMessageDialog(null, "Ваш їжак голодний", "Голод", JOptionPane.INFORMATION_MESSAGE);
            setHungry(true);
            this.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
