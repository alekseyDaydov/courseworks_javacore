package pro.sky.java.course2.examinerservice.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class JavaQuestionServiceTest {

    private JavaQuestionService service;

//    public JavaQuestionServiceTest(JavaQuestionService service) {
//        this.service = service;
//    }

    private final Question question1 = new Question("question1", "answer1");
    private final Question question2 = new Question("question2", "answer2");
    private final Question question3 = new Question("question3", "answer3");

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    //Ввод: добавление нового вопроса, вывод новый вопрос
    @Test
    void whenAdd_thenNewQuestionReturnsQuestion() {
        Question newQuestion = new Question("quest1", "answer1");
        Question result = service.add(newQuestion);
        assertEquals(newQuestion, result);
        assertTrue(service.getAll().contains(newQuestion));
    }

    //Ввод: добавление нового вопроса, который уже существует, вывод исключение
    @Test
    void whenAdd_thenDuplicateQuestionReturnThrowsException() {
        service.add(question1);
        NoSuchQuestionException result = assertThrows(NoSuchQuestionException.class, () -> service.add(question1));
        assertEquals("Невозможно добавить вопрос! Вопрос существует!!!", result.getMessage());
    }

    //Ввод:Удаление существующего вопроса, вывод удаленный вопрос
    @Test
    void whenRemove_thenExistingQuestionReturnsQuestion() {
        service.add(question1);
        Question toRemove = new Question("question1", "answer1");
        Question result = service.remove(toRemove);
        assertEquals(toRemove, result);
        assertEquals(0, service.getAll().size());
    }

    //Ввод:Удаление несуществующего вопроса, вывод исключение
    @Test
    void whenRemove_thenNotExistingQuestionReturnThrowsException() {
        Question nonExisting = new Question("Non existing", "no");
        assertThrows(NoSuchQuestionException.class, () -> service.remove(nonExisting));
    }

    //Ввод_____, вывод получение всей коллекции
    @Test
    void whenGetAllReturnsAllQuestions() {
        service.add(question1);
        service.add(question2);
        Collection<Question> all = service.getAll();
        assertEquals(2, all.size());
    }

    //Ввод___ в коллекции нет вопросов, вывод пустой вопрос
    @Test
    void whenGetRandomQuestion_thenWithEmptySet_ReturnNull() {
        assertNull(service.getRandomQuestion());
    }

    //Ввод ___есть три вопроса в коллекции, вывод 3 вопроса в коллекции
    @Test
    void whenGetRandomQuestion_thenThreeQuestionCollectionReturnThreeQuestionCollection() {
        service.add(question1);
        service.add(question2);
        service.add(question3);
        Question result = service.getRandomQuestion();
        assertTrue(Set.of(question1,question2,question3).contains(result));
    }
}

