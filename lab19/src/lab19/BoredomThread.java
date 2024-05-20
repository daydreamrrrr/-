package lab19;

import javax.swing.JOptionPane;
import static lab19.MainFrame.LifeThread.setAttention;

public class BoredomThread extends Thread {

    public void run() {
        try {
            setAttention(false);
            Thread.sleep(20000);
            JOptionPane.showMessageDialog(null, "Ваш їжак нудьгує", "Нудьга", JOptionPane.INFORMATION_MESSAGE);
            setAttention(true);
            this.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
