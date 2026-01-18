package pro.sky.java.course2.examinerservice.exception;

public class NoSuchQuestionException extends RuntimeException {
    public NoSuchQuestionException(String message) {
        super(message);
    }
}
