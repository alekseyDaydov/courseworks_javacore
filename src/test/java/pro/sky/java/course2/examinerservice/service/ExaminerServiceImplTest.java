package pro.sky.java.course2.examinerservice.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;
import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionServices questionServices;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Question question1 = new Question("question1", "answer1");
    private final Question question2 = new Question("question2", "answer2");
    private final Question question3 = new Question("question3", "answer3");

    //Ввод: параметр кол-во вопросов равна нулю, вывод пустая коллекция
    @Test
    void whenGetQuestion_thenInputZeroAmountReturnEmptyCollection() {
        Collection<Question> result = examinerService.getQuestions(0);
        assertTrue(result.isEmpty());
    }

    //Ввод: параметр кол-во вопросов отрицательное число, вывод Исключение
    @Test
    void whenGetQuestion_thenInputNegativeAmountReturnThrows() {
        NoSuchQuestionException result = assertThrows(NoSuchQuestionException.class, () -> examinerService.getQuestions(-1));
        assertEquals("Ввод отрицательного числа", result.getMessage());
    }

    // Ввод: параметр кол-во вопросов превышает общее кол-во вопросов в коллекции, вывод Исключение
    @Test
    void whenGetQuestion_thenInputAmountMoreAllQuestionsReturnThrows() {
        when(questionServices.getAll()).thenReturn(Set.of(question1, question2, question3));
        NoSuchQuestionException result = assertThrows(NoSuchQuestionException.class, () -> examinerService.getQuestions(4));
        assertEquals("Номер вопроса превышает общее количество вопросов", result.getMessage());
    }

    //Ввод: параметр кол-ва вопросов не превышает общее кол-во вопросов в коллекции, вывод коллекции из кол-ва вопросов
    @Test
    void whenGetQuestion_thenInputTwoAmountAllThreeQuestionsReturnCollectionSizeTwo() {
        Set<Question> questionSet = Set.of(question1, question2, question3);
        when(questionServices.getAll()).thenReturn(questionSet);
        when(questionServices.getRandomQuestion()).thenReturn(question1, question2, question1);
        Collection<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
        assertTrue(result.contains(question1));
        assertTrue(result.contains(question2));
    }

    //Ввод: параметр кол-ва вопросов не превышает общее кол-во вопросов в коллекции, получение пустого Вопроса из метода getRandom вывод коллекции из кол-ва вопросов
    @Test
    void whenGetQuestion_thenInputTwoAmountAllThreeQuestionsNullQuestionGetRandomReturnCollectionSizeTwo() {
        Set<Question> questionSet = Set.of(question1, question2, question3);
        when(questionServices.getAll()).thenReturn(questionSet);
        when(questionServices.getRandomQuestion()).thenReturn(null, question1, question2, question1);
        Collection<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
        assertTrue(result.contains(question1));
        assertTrue(result.contains(question2));
        verify(questionServices,atLeast(3)).getRandomQuestion();
    }
}

