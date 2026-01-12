package pro.sky.java.course2.examinerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionServices;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    @Autowired
    private QuestionServices questionService;

    //   /add?question=QuestionText&answer=QuestionAnswer
    @GetMapping(path = "/add")
    Question addQuestion(@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    // /remove?question=QuestionText&answer=QuestionAnswer
    @GetMapping(path = "/remove")
    Question removeQuestion(@RequestParam("question") String question,
                            @RequestParam("answer") String answer) {
        Question quest = new Question(question, answer);
        questionService.remove(quest);
        return quest;
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping(path = "/find")
    Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }

}
