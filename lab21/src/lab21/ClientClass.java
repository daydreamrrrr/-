package lab21;

import javax.swing.JPanel;

public class ClientClass {

    private final Button button;
    private final JPanel panel;
    private final Checkbox checkbox;

    public ClientClass(GUIFactory factory, JPanel panel) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
        this.panel = panel;
    }

    public void paint() {
        button.render(panel);
        button.onClick();
        checkbox.render(panel);
        checkbox.onSelect();
    }
}
