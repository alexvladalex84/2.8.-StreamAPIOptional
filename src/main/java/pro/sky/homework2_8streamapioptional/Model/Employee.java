package pro.sky.homework2_8streamapioptional.Model;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final double salary;

    private final Integer department;

    public Employee(String firstName, String lastName, String patronymic, double salary, Integer department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, salary, department);
    }
}

