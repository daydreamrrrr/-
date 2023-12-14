package employees.developers;

/**
 * Клас бекенд розробника
 */
public class Backend extends Developer {

    /**
     * Мова
     */
    private String backendSkill;

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплатаF
     * @param backendSkill мова
     */
    public Backend(String name, double salary, String backendSkill) {
        super(name, salary);
        this.backendSkill = backendSkill;
    }

    /**
     * Вивід зарплати
     */
    @Override
    public void printSalary() {
        System.out.println("Зарплата Backend розробника " + name + ": " + salary + "$");
    }
}
