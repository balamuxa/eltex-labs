package ru.eltex.app.java.lab7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class Exceptions extends ReflectiveOperationException{

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity nullPointerExceptions(){
        return new ResponseEntity("1-нет заказа с таким id", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity IOExceptions(){
        return new ResponseEntity("2-файл поврежден", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
