package pro.sky.homework2_8streamapioptional.Service;


import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.util.Collection;
import java.util.List;

public interface SalaryService {


    List<Employee> listEmployeeByDepartmentId(int departmentId);

    List<Employee> listEmployeeSeparationByDepartmentId();

    List<Employee> maxSalaryByDepartment(int department);

    Collection<Employee> listEmployee();

    List<Employee> minSalaryByDepartment(int department);
}
