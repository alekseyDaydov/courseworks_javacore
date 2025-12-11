package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionServices;

import java.util.Collection;

@RestController
@RequestMapping
public class JavaQuestionController {
    private QuestionServices questionService;

    public JavaQuestionController(QuestionServices questionService) {
        this.questionService = questionService;
    }

    QuestionServices addQuestion(String question, String answer) {
        return null;
    }

    Collection<Question> getQuestions() {
        return null;
    }


}
