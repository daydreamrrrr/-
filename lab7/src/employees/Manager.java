package employees;

/**
 * Клас менеджера
 */
public class Manager extends Employee {

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     */
    public Manager(String name, double salary) {
        super(name, salary);
    }

    /**
     * Вивід зарплати
     */
    @Override
    public void printSalary() {
        System.out.println("Зарплата менеджера " + name + ": " + salary + "$");
    }
}
