package models.member;

import Validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest> {
    private MemberDao memberDao;

    @Override
    public void check(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        //id, pw 빈공간시 예외발생
        blankCheck(userId,new FailException("아이디를 작성해주세요"));
        blankCheck(userPw,new FailException("비밀번호를 작성해주세요"));
        // 등록된 아이디 인지 체크 - memberDao
        Member member = memberDao.get(userId);
        if(member == null){
            throw new FailException("등록된 회원이 아닙니다.");
        }
    }
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }


}
