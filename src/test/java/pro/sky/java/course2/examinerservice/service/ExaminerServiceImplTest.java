package pro.sky.java.course2.examinerservice.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionServices questionServices;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions_returnsCorrectAmountUniqueQuestions() {
        // Arrange
        Question q1 = new Question("q1", "a1");
        Question q2 = new Question("q2", "a2");
        Question q3 = new Question("q3", "a3");
        when(questionServices.getRandomQuestion())
                .thenReturn(q1, q2, q3, q1); // Repeat q1 to test deduplication

        // Act
        Collection<Question> result = examinerService.getQuestions(3);

        // Assert
        assertEquals(3, result.size());
        assertTrue(result.contains(q1));
        assertTrue(result.contains(q2));
        assertTrue(result.contains(q3));
        verify(questionServices, times(4)).getRandomQuestion();
    }

    @Test
    void getQuestions_returnsEmpty_whenAmountZero() {
        // Act
        Collection<Question> result = examinerService.getQuestions(0);

        // Assert
        assertTrue(result.isEmpty());
        verifyNoInteractions(questionServices);
    }
}

