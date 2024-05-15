package lab21;

import javax.swing.JPanel;

public class ClientClass {

    private final Button button;
    private final JPanel panel;

    public ClientClass(ButtonFactory factory, JPanel panel) {
        this.button = factory.createButton();
        this.panel = panel;
    }

    public void paint() {
        button.render(panel);
        button.onClick();
    }
}
