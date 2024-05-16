package lab21;

public class MacOSGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }

}
