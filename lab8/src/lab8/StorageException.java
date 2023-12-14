package lab8;

/**
 * клас обробки виключних ситуацій
 */
public class StorageException extends Exception {

    /**
     * викидує помилку
     *
     * @param message повідомлення помилки
     */
    public StorageException(String message) {
        super(message);
    }
}
