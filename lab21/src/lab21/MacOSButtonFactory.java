package lab21;

public class MacOSButtonFactory implements ButtonFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

}
