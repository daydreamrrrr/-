package employees.developers;

import employees.Employee;

/**
 * Абстрактний клас розробників
 */
public abstract class Developer extends Employee {

    /**
     * Мови
     */
    protected String skill;

    /**
     * Конструктор
     *
     * @param name ім'я
     * @param salary зарплата
     * @param skill мова
     */
    public Developer(String name, double salary, String skill) {
        super(name, salary);
        this.skill = skill;
    }

    /**
     * Інформація про мови
     */
    public void printSkill() {
        System.out.println("Мова програмування: " + skill);
    }
}
