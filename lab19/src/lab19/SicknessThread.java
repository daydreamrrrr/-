package lab19;

import javax.swing.JOptionPane;
import static lab19.MainFrame.LifeThread.getAttention;
import static lab19.MainFrame.LifeThread.getHappiness;
import static lab19.MainFrame.LifeThread.getHungry;
import static lab19.MainFrame.LifeThread.getSick;
import static lab19.MainFrame.LifeThread.getThirst;
import static lab19.MainFrame.LifeThread.setAlive;
import static lab19.MainFrame.LifeThread.setSick;

public class SicknessThread extends Thread {

    public void run() {
        try {
            Thread.sleep(5000);
            if (getHungry() && getThirst() && getAttention() && getHappiness()) {
                setSick(true);
                JOptionPane.showMessageDialog(null, "Ваш їжак захворів", "Хвороба", 2);
            }
            if(getSick()) {
                Thread.sleep(3000);
                if(getSick()) {
                    setAlive(false);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
