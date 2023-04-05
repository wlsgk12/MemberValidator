package Validator;

public interface CommonValidator {
    //많이 사용하는 검증들 default 함수로 정의

    //id나 pw가 빈공간이 있는지 체크후 빈공간이면 예외 발생
    default void blankCheck(String str,RuntimeException e){
        if(str ==null || str.isBlank()){
            throw e;
        }

    }
    //id, pw 길이 체크후 min, max에 벗어나면 예외발생
    default void lengthCheck(String str, int min, int max, RuntimeException e){
        if(str.length()<min || str.length()>max){
            throw e;
        }
    }
    //max 설정을 안했을 경우 0으로 두고 위 lengthCheck 함수 실행
    default void lengthCheck(String str, int min, RuntimeException e){
        lengthCheck(str, min, 0, e);
    }
}
