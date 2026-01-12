package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionServices {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new NoSuchQuestionException("Невозможно добавить вопрос! Вопрос существует!!!");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NoSuchQuestionException("Невозможно удалить вопрос! Нет такого вопроса");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.stream().toList();
    }

    @Override
    public Question getRandomQuestion() {
        //получил рандомное число
        int numberQuestion = (int) (Math.random() * 10); //(Integer.MAX_VALUE));
        if (numberQuestion > questions.size()) {
            throw new NoSuchQuestionException("Нет вопроса с данным номером");
        }
        // беру коллекцию и выбираю данное число
        Iterator<Question> iterator = questions.iterator();
        Question question = new Question();
        int i = 0;
        while (i < numberQuestion) {
            question = iterator.next();
            i++;
        }
        return question;
    }
}
