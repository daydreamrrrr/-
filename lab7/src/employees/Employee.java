package employees;

/**
 * Абстрактний клас робітників
 */
public abstract class Employee {

    /**
     * Ім'я
     */
    protected String name;
    /**
     * Зарплата
     */
    protected double salary;

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Вивід зарплати
     */
    public abstract void printSalary();
}
