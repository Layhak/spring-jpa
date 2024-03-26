package co.istad.jbsdemo.springjba.adviser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class RestControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new HashMap<>() {{
            put("errors", ex.getBindingResult().getFieldErrors().stream().map(e -> e.getField() + " " + e.getDefaultMessage()).toList());
        }};
    }
}
