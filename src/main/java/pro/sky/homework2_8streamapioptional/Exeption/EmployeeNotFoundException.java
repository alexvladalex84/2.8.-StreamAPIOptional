package pro.sky.homework2_8streamapioptional.Exeption;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
