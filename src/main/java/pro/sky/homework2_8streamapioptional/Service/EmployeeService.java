package pro.sky.homework2_8streamapioptional.Service;

import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.net.BindException;
import java.util.Collection;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName, String patronymic, double salary, int department) throws BindException;

    Employee deleteEmployee(String firstName, String lastName, String patronymic, double salary, int department);

    Employee findEmployee(String firstName, String lastName, String patronymic, double salary, int department);

    Collection<Employee> listEmployees();


    void numberDepartmentMaxMin(int department);
}
