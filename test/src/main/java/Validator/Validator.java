package Validator;

public interface Validator<T> extends CommonValidator {
    void check(T t);
}
