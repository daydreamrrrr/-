package lab21;

public class WinButtonFactory implements ButtonFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
