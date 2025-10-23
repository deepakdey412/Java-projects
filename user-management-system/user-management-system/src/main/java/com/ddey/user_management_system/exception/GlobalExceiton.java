package com.ddey.user_management_system.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceiton {
    @ExceptionHandler(UserNotFoundException.class)

}
