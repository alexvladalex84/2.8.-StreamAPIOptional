package pro.sky.homework2_8streamapioptional.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ArrayIsFull extends RuntimeException {
    public ArrayIsFull(String message) {
        super(message);
    }
}
