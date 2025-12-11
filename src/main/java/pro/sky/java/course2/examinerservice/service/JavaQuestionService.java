package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

public class JavaQuestionService implements QuestionServices {
   private Set<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
         questions.add(new Question(question,answer));
        return  null;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return null;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.stream().toList();
    }

    @Override
    public Integer getRandomQuestion() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }
}
