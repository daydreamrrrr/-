package employees.developers;

/**
 * Клас бекенд розробника
 */
public class Backend extends Developer {

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     * @param skill мова
     */
    public Backend(String name, double salary, String skill) {
        super(name, salary, skill);
    }

    /**
     * Вивід зарплати
     */
    @Override
    public void printSalary() {
        System.out.println("Зарплата Backend розробника " + name + ": " + salary + "$");
    }

    /**
     * Інформація про мови
     */
    @Override
    public void printSkill() {
        System.out.println("Мова програмування: " + skill);
    }
}
