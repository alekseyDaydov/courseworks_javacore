package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.List;

public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionServices questionServices;

    public ExaminerServiceImpl(QuestionServices questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return questionServices.getAll();
    }
}
