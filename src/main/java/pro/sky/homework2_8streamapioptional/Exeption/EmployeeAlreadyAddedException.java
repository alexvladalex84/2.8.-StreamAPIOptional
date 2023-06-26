package pro.sky.homework2_8streamapioptional.Exeption;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
