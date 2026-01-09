package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    Collection<Question> getQuestions(@RequestParam("amount") Integer amount) {
        return examinerServices.getQuestions(amount);
    }
}
