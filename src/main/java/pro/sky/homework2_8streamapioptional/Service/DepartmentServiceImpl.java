package pro.sky.homework2_8streamapioptional.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_8streamapioptional.Exeption.EmployeeNotFoundException;
import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Collection<Employee> listEmployee() {                         //список сотрудников
        return employeeService.listEmployees().stream()
                .collect(Collectors.toList());

    }

    @Override
    public Employee maxSalaryByDepartment(int department) {
        employeeService.numberDepartmentMaxMin(department);
        return streamByDepartment(department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));


    }

    @Override
    public Employee minSalaryByDepartment(int department) {
        employeeService.numberDepartmentMaxMin(department);
        return streamByDepartment(department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }


    @Override
    public Map<Integer, List<Employee>> getAllByDepartment(Integer departmentId) {
        return streamByDepartment(departmentId)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.toList()));


    }


    private Stream<Employee> streamByDepartment(Integer departmentId) {
        List<Employee> employees = (List<Employee>) listEmployee();
        return employees.stream()
                .filter(e -> departmentId == null || e.getDepartment().equals(departmentId));
    }

}

