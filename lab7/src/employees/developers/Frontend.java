package employees.developers;

/**
 * Клас фронтенд розробника
 */
public class Frontend extends Developer {

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     * @param skill мова
     */
    public Frontend(String name, double salary, String skill) {
        super(name, salary, skill);
    }

    /**
     * Вивід зарплати
     */
    @Override
    public void printSalary() {
        System.out.println("Зарплата Frontend розробника " + name + ": " + salary + "$");
    }

    /**
     * Інформація про мови
     */
    @Override
    public void printSkill() {
        System.out.println("Мова програмування: " + skill);
    }
}
