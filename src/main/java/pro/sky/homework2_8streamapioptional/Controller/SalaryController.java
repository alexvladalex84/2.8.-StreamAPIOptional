package pro.sky.homework2_8streamapioptional.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2_8streamapioptional.Model.Employee;
import pro.sky.homework2_8streamapioptional.Service.SalaryService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/departments")

public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping(path = "/max-salary")
    public List<Employee> maxSalaryById(@RequestParam("department") int department) {
        return salaryService.maxSalaryByDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public List<Employee> minSalaryById(@RequestParam("department") int department) {
        return salaryService.minSalaryByDepartment(department);
    }

    @GetMapping(path = "/all-by-department")
    public List<Employee> listEmployeeByDepartmentId(@RequestParam("departmentId") int departmentId) {
        return salaryService.listEmployeeByDepartmentId(departmentId);

    }

    @GetMapping(path = "/all")
    public List<Employee> listEmployeeSeparationByDepartmentId() {
        return salaryService.listEmployeeSeparationByDepartmentId();

    }

    @GetMapping
    public Collection<Employee> listEmployee() {
        return salaryService.listEmployee();
    }

}



