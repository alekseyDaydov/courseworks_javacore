package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

public class JavaQuestionService implements QuestionServices {
   private Set<Question> questions = new HashSet<>();
    @Override
    public Question add(String question) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return List.of();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomNumber = random.nextInt(Integer.MAX_VALUE);

        Iterator<Question> iterator = questions.iterator();
//       iterator.next().
        return null;
    }
}
