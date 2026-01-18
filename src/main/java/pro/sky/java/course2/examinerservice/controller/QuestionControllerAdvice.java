package pro.sky.java.course2.examinerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;
import pro.sky.java.course2.examinerservice.exception.QuestionError;

@ControllerAdvice
public class QuestionControllerAdvice {
    private final static String CODE_BAD_REQUEST = "BAD_REQUEST";

    @ExceptionHandler(NoSuchQuestionException.class)
    ResponseEntity<QuestionError> noSuchQuestion(NoSuchQuestionException e) {
        return new ResponseEntity<>(new QuestionError(CODE_BAD_REQUEST, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
