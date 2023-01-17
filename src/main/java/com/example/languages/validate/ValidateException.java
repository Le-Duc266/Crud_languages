package com.example.languages.validate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ValidateException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> reObjectMap = new LinkedHashMap<>();
        reObjectMap.put("timestamp",new Date());
        reObjectMap.put("status",status.value());

        List<FieldError> fieldError =  ex.getBindingResult().getFieldErrors();
        List<String> listError = new ArrayList<>();
        for (FieldError error : fieldError){
            String errorMesage = error.getDefaultMessage();
            listError.add(errorMesage);
        }
        reObjectMap.put("error",listError);
        return new ResponseEntity<>(reObjectMap,headers,status);
    }
}
