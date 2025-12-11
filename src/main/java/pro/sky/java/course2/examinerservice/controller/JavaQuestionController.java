package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionServices;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionServices questionService;

    public JavaQuestionController(QuestionServices questionService) {
        this.questionService = questionService;
    }

    QuestionServices addQuestion(String question, String answer) {
         questionService.add(new Question(question,answer));
        return null;
    }
    QuestionServices removeQuestion(Question question) {
        questionService.remove(question);
        return null;
    }
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }


}
