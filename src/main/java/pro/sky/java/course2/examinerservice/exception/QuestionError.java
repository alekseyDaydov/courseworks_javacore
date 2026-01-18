package pro.sky.java.course2.examinerservice.exception;

public final class QuestionError {
    private final String code;
    private final String message;

    public QuestionError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
