package pro.sky.homework2_8streamapioptional.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_8streamapioptional.Exeption.ArrayIsFull;
import pro.sky.homework2_8streamapioptional.Exeption.EmployeeAlreadyAddedException;
import pro.sky.homework2_8streamapioptional.Exeption.EmployeeNotFoundException;
import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int amountWorkers = 3;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    public Map<String, Employee> getEmployees() {
        return employees;

    }


    @Override
    public Employee addEmployee(String firstName, String lastName, String patronymic, double salary, int department) {
        Employee name = new Employee(firstName, lastName, patronymic, salary, department);
        if (employees.size() > amountWorkers) {
            throw new ArrayIsFull("Привышен лимит количества сотрудников!");
        } else if (employees.containsKey(getFullName(name))) {
            throw new EmployeeAlreadyAddedException("Попытка добавить уже существующего сотрудника!");
        } else {
            employees.put(getFullName(name), name);
        }
        return name;


    }


    @Override
    public Employee deleteEmployee(String firstName, String lastName, String patronymic, double salary, int department) {

        Employee name = new Employee(firstName, lastName, patronymic, salary, department);
        String fullName = getFullName(name);
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Попытка найти не существующего сотрудника для удаления его из списка! ");
        } else {
            employees.remove(fullName, name);
        }
        return name;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName, String patronymic, double salary, int department) {
        Employee name = new Employee(firstName, lastName, patronymic, salary, department);
        String fullName = getFullName(name);
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Попытка найти не существующего сотрудника в поиске!");
        } else {
            employees.containsKey(fullName);
        }
        return name;
    }

    @Override
    public Collection<Employee> listEmployees() {

        return Collections.unmodifiableCollection(employees.values());

    }


    public String getFullName(Employee employee) {
        return employee.getFirstName() + " " + employee.getFirstName() + " "
                + employee.getPatronymic() + " " + employee.getSalary() + " " + employee.getDepartment();
    }

}