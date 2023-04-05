package models.member;

import Validator.Validator;

public class JoinService {
    private Validator validator;
    private MemberDao memberDao;
    public JoinService(Validator validator, MemberDao memberDao){
        this.validator=validator;
        this.memberDao=memberDao;
    }
    public void join(Member member){
        validator.check(member);
        //회원 추가
        memberDao.add(member);
    }
}
