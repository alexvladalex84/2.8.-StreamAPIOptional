package pro.sky.homework2_8streamapioptional.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.homework2_8streamapioptional.Exeption.*;
import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.net.BindException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int amountWorkers = 5;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }



    @Override
    public Employee addEmployee(String firstName, String lastName, String patronymic, double salary, int department) throws BindException {

        numberDepartmentMaxMin(department);
        if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName) || StringUtils.isEmpty(patronymic)) {
            throw new ArrayIsFull("Строки фио не заполнены");
        }
        checkAlpha(firstName, lastName, patronymic);
        checkUpperCase(firstName, lastName, patronymic);

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


    private String getFullName(Employee employee) {

        return employee.getFirstName() + " " + employee.getFirstName() + " "
                + employee.getPatronymic() + " " + employee.getSalary() + " " + employee.getDepartment();
    }
    @Override
    public void numberDepartmentMaxMin(int department) {

        if (department < 1 || department > 5) {
            throw new NumberDepartmentException("Некорректный номер департамента");
        }
    }

    private void checkUpperCase(String firstName, String lastName, String patronymic) {
        String firstNameInUpperCase = StringUtils.capitalize(firstName);
        String lastNameInUpperCase = StringUtils.capitalize(lastName);
        String patronymicInUpperCase = StringUtils.capitalize(patronymic);
        if (!firstNameInUpperCase.equals(firstName)) {
            throw new InvalidNameException("Имя не с заглавной буквы");
        } if (!lastNameInUpperCase.equals(lastName)) {
            throw new InvalidNameException("Фамилия не с заглавной буквы");
        } if (!patronymicInUpperCase.equals(patronymic)) {
            throw new InvalidNameException("Отчество не с заглавной буквы");
        }

    }

    private void checkAlpha(String firstName, String lastName, String patronymic) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidNameException("Имя содержит запрещенные знаки");
        }if (!StringUtils.isAlpha(lastName)) {
            throw new InvalidNameException("Фамилия содержит запрещенные знаки");
        }if (!StringUtils.isAlpha(patronymic)) {
            throw new InvalidNameException("Отчество содержит запрещенные знаки");
        }
    }

}