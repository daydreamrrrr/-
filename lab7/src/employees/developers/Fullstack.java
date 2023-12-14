package employees.developers;

/**
 * Клас фулстак розробника
 */
public class Fullstack extends Developer {

    /**
     * Мова бекенду
     */
    private String backendSkill;
    /**
     * Мова фронтенду
     */
    private String frontendSkill;

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     * @param backendSkill мова бекенду
     * @param frontendSkill мова фронтенду
     */
    public Fullstack(String name, double salary, String backendSkill, String frontendSkill) {
        super(name, salary);
        this.backendSkill = backendSkill;
        this.frontendSkill = frontendSkill;
    }

    /**
     * Вивід зарплати
     */
    @Override
    public void printSalary() {
        System.out.println("Зарплата Fullstack розробника " + name + ": " + salary + "$");
    }

}
