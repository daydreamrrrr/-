package lab8;

/**
 * клас камери зберігання
 */
public class StorageCamera {

    /**
     * масив комірок
     */
    private Item[][] storageGrid;

    /**
     * Конструктор
     *
     * @param rows рядки
     * @param columns стовпчики
     */
    public StorageCamera(int rows, int columns) {
        storageGrid = new Item[rows][columns];
    }

    /**
     * зберігає предмет в комірці
     *
     * @param row рядок
     * @param column стовпчик
     * @param item предмет
     * @throws StorageException неправильні координати або зайнята комірка
     */
    public void storeItem(int row, int column, Item item) throws StorageException {
        if (row < 0 || row >= storageGrid.length || column < 0 || column >= storageGrid[0].length) {
            throw new StorageException("Неправильні координати комірки");
        }

        if (storageGrid[row][column] != null) {
            throw new StorageException("Ця комірка вже зайнята");
        }
        storageGrid[row][column] = item;
        System.out.println("Предмет \"" + item.getName() + "\" збережено в комірці " + (row + 1) + "-" + (column + 1));
    }

    /**
     * вилучає предмет з комірки
     *
     * @param row рядок
     * @param column стовпчик
     * @return предмет
     * @throws StorageException неправильні координати або відсутність предмета
     */
    public Item retrieveItem(int row, int column) throws StorageException {
        if (row < 0 || row >= storageGrid.length || column < 0 || column >= storageGrid[0].length) {
            throw new StorageException("Неправильні координати комірки");
        }
        /**
         * екземпляр класу Item
         */
        Item item = storageGrid[row][column];
        if (item == null) {
            throw new StorageException("У цій комірці немає збережених предметів");
        }
        storageGrid[row][column] = null;
        System.out.println("Предмет \"" + item.getName() + "\" вилучено з комірки " + (row + 1) + "-" + (column + 1));
        return item;
    }
}
