package employees.developers;

/**
 * Клас фулстак розробника
 */
public class Fullstack extends Developer {

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     * @param skill мова
     */
    public Fullstack(String name, double salary, String skill) {
        super(name, salary, skill);
    }

    /**
     * Вивід зарплати
     */
    @Override
    public void printSalary() {
        System.out.println("Зарплата Fullstack розробника " + name + ": " + salary + "$");
    }

    /**
     * Інформація про мови
     */
    @Override
    public void printSkill() {
        System.out.println("Мова програмування: " + skill);
    }
}
