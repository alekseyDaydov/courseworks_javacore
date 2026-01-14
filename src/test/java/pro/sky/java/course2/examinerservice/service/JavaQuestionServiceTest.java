package pro.sky.java.course2.examinerservice.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JavaQuestionServiceIntegrationTest {

    @Autowired
    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service.add("What is Java?", "Programming language");
        service.add("What is OOP?", "Object Oriented Programming");
    }

    @Test
    void add_newQuestion_returnsQuestion() {
        Question newQ = new Question("What is Spring?", "Framework");
        Question result = service.add(newQ);
        assertEquals(newQ, result);
        assertEquals(3, service.getAll().size());
    }

    @Test
    void add_duplicateQuestion_throwsException() {
        Question duplicate = new Question("What is Java?", "Programming language");
        assertThrows(NoSuchQuestionException.class, () -> service.add(duplicate));
    }

    @Test
    void remove_existingQuestion_returnsQuestion() {
        Question toRemove = new Question("What is Java?", "Programming language");
        Question result = service.remove(toRemove);
        assertEquals(toRemove, result);
        assertEquals(1, service.getAll().size());
    }

    @Test
    void remove_nonExistingQuestion_throwsException() {
        Question nonExisting = new Question("Non existing", "no");
        assertThrows(NoSuchQuestionException.class, () -> service.remove(nonExisting));
    }

    @Test
    void getAll_returnsAllQuestions() {
        Collection<Question> all = service.getAll();
        assertEquals(2, all.size());
    }
}

