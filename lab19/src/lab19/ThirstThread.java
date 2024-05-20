package lab19;

import javax.swing.JOptionPane;
import static lab19.MainFrame.LifeThread.setThirst;

public class ThirstThread extends Thread {

    public void run() {
        try {
            setThirst(false);
            Thread.sleep(10000);
            JOptionPane.showMessageDialog(null, "Ваш їжак хоче пити", "Спрага", JOptionPane.INFORMATION_MESSAGE);
            setThirst(true);
            this.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
