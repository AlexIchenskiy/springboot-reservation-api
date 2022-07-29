package com.agency04.devcademy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public final ModelAndView handleAllExceptions(Exception e) {
        ModelAndView model = new ModelAndView("error/generic_error");

        model.addObject("errMsg", "This is Exception.class");

        return model;
    }

}
