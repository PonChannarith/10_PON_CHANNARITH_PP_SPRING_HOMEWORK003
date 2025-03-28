package org.example._10_pon_cahannarith_pp_spring_homework003.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
//for exception

@RestController
public class GlobalException {
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail notFoundExceptionHeandler(NotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND , e.getMessage());
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return problemDetail;

    }


}
