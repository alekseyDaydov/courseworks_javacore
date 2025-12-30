package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionServices {
    private final Set<Question> questions = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question addQuest = new Question(question, answer);
        questions.add(addQuest);
        return addQuest;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new IllegalArgumentException("Нет такого вопроса");
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
        int numberQuestion = (int) (Math.random() * (Integer.MAX_VALUE));
        for(int i = 0; i == numberQuestion; i++){

        }
        // беру коллекцию и выбираю данное число
        questions.iterator();
        return null;
    }
}
