package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionServices questionServices;

    public ExaminerServiceImpl(QuestionServices questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            Question question = questionServices.getRandomQuestion();
            if (!questions.contains(question)) {
                questions.add(question);
            }
        }
        return questions;
    }
}
