package models.member;

public class FailException extends RuntimeException{
    public FailException(String message) {
        super(message);
    }
}
