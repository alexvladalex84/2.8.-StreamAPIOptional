package pro.sky.homework2_8streamapioptional.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2_8streamapioptional.Model.Employee;
import pro.sky.homework2_8streamapioptional.Service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName
            , @RequestParam("patronymic") String patronymic, @RequestParam("salary") double salary, @RequestParam("department") int department) {
        return employeeService.addEmployee(firstName, lastName, patronymic, salary, department);
//            try {
//
//            } catch (ArrayIsFull e) {
//                e.printStackTrace();
//                return String.format("Привышен лимит количества сотрудников %s", employeeService.listEmployees());
//
//            } catch (EmployeeAlreadyAddedException e) {
//                e.printStackTrace();
//                return "Сотрудник " + firstName + " " + lastName + " уже сущестует ";
//            }
    }

    @GetMapping(path = "/remove")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName
            , @RequestParam("patronymic") String patronymic, @RequestParam("salary") double salary, @RequestParam("department") int department) {
        return employeeService.deleteEmployee(firstName, lastName, patronymic, salary, department);
//            try {
//            } catch (EmployeeNotFoundException e) {
//                e.printStackTrace();
//                return "Такого сотрудника не существует " + employeeService.listEmployees();
//            }

    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName
            , @RequestParam("patronymic") String patronymic, @RequestParam("salary") double salary, @RequestParam("department") int department) {
        return employeeService.findEmployee(firstName, lastName, patronymic, salary, department);
//            try {
//            } catch (EmployeeNotFoundException e) {
//                e.printStackTrace();
//                return "Такого сотрудника не существует " + employeeService.listEmployees();
//
//            }
    }

    @GetMapping
    public Collection<Employee> listEmployees() {

        return employeeService.listEmployees();
    }
}
