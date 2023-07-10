package pro.sky.homework2_8streamapioptional.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.homework2_8streamapioptional.Exeption.InvalidNameException;
import pro.sky.homework2_8streamapioptional.Model.Employee;
import pro.sky.homework2_8streamapioptional.Service.EmployeeService;

import java.net.BindException;
import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @ExceptionHandler({InvalidNameException.class})
    public ResponseEntity<String> handlerException(InvalidNameException e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName
            , @RequestParam("patronymic") String patronymic, @RequestParam("salary") double salary, @RequestParam("department") int department) throws BindException {
        return employeeService.addEmployee(firstName, lastName, patronymic, salary, department);

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
