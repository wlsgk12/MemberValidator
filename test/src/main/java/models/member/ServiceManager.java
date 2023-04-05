package models.member;

import Validator.Validator;

public class ServiceManager {

    public MemberDao memberDao(){
        return new MemberDao();
    }
    public Validator joinValidator(){
        return new JoinValidator();
    }
    public Validator loginValidator(){
        LoginValidator validator = new LoginValidator();
        validator.setMemberDao(memberDao());
        return validator;
    }
    public JoinService getJoinValidator(){
        JoinService service=new JoinService(joinValidator(),memberDao());
        return service;
    }
    public LoginService getLoginValidator(){
        LoginService service=new LoginService(loginValidator(),memberDao());
        return service;
    }

}
