package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionServices;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionServices questionService;

    public JavaQuestionController(QuestionServices questionService) {
        this.questionService = questionService;
    }
    
//   /add?question=QuestionText&answer=QuestionAnswer
    @GetMapping("/add")
    QuestionServices addQuestion(@RequestParam("question") String question,
                                  @RequestParam("answer") String answer) {
        Question quest = new Question(question, answer);

//        return quest;
          questionService.add(quest);
        return (QuestionServices) quest;
    }

   // /remove?question=QuestionText&answer=QuestionAnswer

    QuestionServices removeQuestion(@RequestParam("question") String question,
                                    @RequestParam("answer") String answer) {
        Question quest = new Question(question, answer);
        questionService.remove(quest);
        return null;
}
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }


}
