package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;

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

        if (amount < 0) {
            throw new NoSuchQuestionException("Ввод отрицательного числа");
        } else if (amount == 0) {
            return questions; // вывод пустой коллекции
        }
        int sizeQuestions = questionServices.getAll().size();
        if (amount > sizeQuestions) {
            throw new NoSuchQuestionException("Номер вопроса превышает общее количество вопросов");
        }

        while (questions.size() < amount) {
            Question quest = questionServices.getRandomQuestion();
            if (quest != null) {
                questions.add(quest);
            }
        }
        return questions;
    }
}
