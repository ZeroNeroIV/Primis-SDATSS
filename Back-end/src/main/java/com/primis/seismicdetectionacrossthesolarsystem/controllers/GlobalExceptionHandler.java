package com.primis.seismicdetectionacrossthesolarsystem.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        System.out.println(Arrays.toString(e.getStackTrace()));
        return e.getMessage();
    }
}
