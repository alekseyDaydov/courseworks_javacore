package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.ExaminerServiceImpl;
import pro.sky.java.course2.examinerservice.service.QuestionServices;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerServices;

    public ExamController(ExaminerService examinerServices) {
        this.examinerServices = examinerServices;
    }

    //        /exam/get/{amount}
    @GetMapping("/get/{amount}")
    Collection<Question> getQuestions(@PathVariable("amount") int amount) {

        return examinerServices.getQuestions(amount);
    }
}
