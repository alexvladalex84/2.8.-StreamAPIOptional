package pro.sky.homework2_8streamapioptional.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_8streamapioptional.Exeption.NumberDepartmentException;
import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final EmployeeService employeeService;

    public SalaryServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Collection<Employee> listEmployee() {                         //список сотрудников
        return employeeService.listEmployees();

    }

    @Override
    public List<Employee> listEmployeeByDepartmentId(int departmentId) {
        Collection<Employee> empl = listEmployee();
        List<Employee> employees = empl.stream().filter(e -> e.getDepartment() == departmentId).collect(Collectors.toList());
        return employees;
    }

    @Override
    public List<Employee> listEmployeeSeparationByDepartmentId() {
        Collection<Employee> empl = listEmployee();
        List<Employee> employees = empl.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());
        return employees;
    }

    @Override
    public List<Employee> maxSalaryByDepartment(int department) {
        Collection<Employee> empl = listEmployee();
        if (department < 1 || department > 5) {
            throw new NumberDepartmentException("Некорректный номер департамента");
        }
        List<Employee> employees = empl.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .stream().collect(Collectors.toList());
        return employees;


    }

    @Override
    public List<Employee> minSalaryByDepartment(int department) {
        Collection<Employee> empl = listEmployee();
        if (department < 1 || department > 5) {
            throw new NumberDepartmentException("Некорректный номер департамента");
        }
        List<Employee> employees = empl.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .stream().collect(Collectors.toList());
        return employees;


    }
}

