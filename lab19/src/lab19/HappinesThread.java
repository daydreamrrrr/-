package lab19;

import javax.swing.JOptionPane;
import static lab19.MainFrame.LifeThread.setHappiness;

public class HappinesThread extends Thread {

    public void run() {
        try {
            setHappiness(false);
            Thread.sleep(20000);
            JOptionPane.showMessageDialog(null, "Ваш їжак хоче обіймів", "Обійми", JOptionPane.INFORMATION_MESSAGE);
            setHappiness(true);
            this.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
