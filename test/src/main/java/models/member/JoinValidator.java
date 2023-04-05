package models.member;

import Validator.Validator;

public class JoinValidator implements Validator<Member> {
    @Override
    public void check(Member member) {
        String userId=member.getUserId();
        String userPw=member.getUserPw();
        //id 빈값 확인
        blankCheck(userId,new FailException("아이디를 입력해주세요"));
        blankCheck(userPw,new FailException("비밀번호를 입력해주세요"));
        //id 길이 체크
        lengthCheck(userId,6,12,new FailException("아이디를 6-12자 이내로 작성해주세요"));
        //Pw 길이 체크
        lengthCheck(userPw,8,16,new FailException("비밀번호를 8-16자 이내로 작성해주세요"));

    }
}
