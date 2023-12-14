package employees.developers;

/**
 * Клас фронтенд розробника
 */
public class Frontend extends Developer {

    /**
     * Мова
     */
    private String frontendSkill;

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     * @param frontendSkill мова
     */
    public Frontend(String name, double salary, String frontendSkill) {
        super(name, salary);
        this.frontendSkill = frontendSkill;
    }

    /**
     * Вивід зарплати
     */
    @Override
    public void printSalary() {
        System.out.println("Зарплата Frontend розробника " + name + ": " + salary + "$");
    }
}
