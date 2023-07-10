package pro.sky.homework2_8streamapioptional.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2_8streamapioptional.Model.Employee;
import pro.sky.homework2_8streamapioptional.Service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")

public class DepartmentController {

    private final DepartmentService salaryService;

    public DepartmentController(DepartmentService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryById(@RequestParam("department") int department) {
        return salaryService.maxSalaryByDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryById(@RequestParam("department") int department) {
        return salaryService.minSalaryByDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllByDepartment(@RequestParam(required = false)Integer departmentId) {
        return salaryService.getAllByDepartment(departmentId);

    }


    @GetMapping
    public Collection<Employee> listEmployee() {
        return salaryService.listEmployee();
    }

}



