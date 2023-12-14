package employees.developers;

import employees.Employee;
/**
 * Абстрактний клас розробників
 */
public abstract class Developer extends Employee {

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     */
    public Developer(String name, double salary) {
        super(name, salary);
    }
}
