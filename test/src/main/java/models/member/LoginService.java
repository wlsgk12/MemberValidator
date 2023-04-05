package models.member;

import Validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginService {
    private MemberDao memberDao;
    private Validator validator;
    public LoginService(Validator validator, MemberDao memberDao){
        this.validator=validator;
        this.memberDao=memberDao;
    }
    public void login(HttpServletRequest request){
        validator.check(request);

        //로그인 처리
        String userId = request.getParameter("userId");
        Member member = memberDao.get(userId);

        HttpSession session = request.getSession();
        session.setAttribute("member",member);

    }
}
