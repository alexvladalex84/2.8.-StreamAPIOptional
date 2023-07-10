package pro.sky.homework2_8streamapioptional.Service;


import pro.sky.homework2_8streamapioptional.Model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {




    Map<Integer, List<Employee>> getAllByDepartment(Integer departmentId);



    Employee maxSalaryByDepartment(int department);

    Collection<Employee> listEmployee();

    Employee minSalaryByDepartment(int department);
}
