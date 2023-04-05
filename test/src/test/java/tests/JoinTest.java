package tests;

import models.member.FailException;
import models.member.JoinService;
import models.member.Member;
import models.member.ServiceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JoinTest {
    private JoinService service;
    private Member member;
    @BeforeEach
    public void init(){
        ServiceManager manager=new ServiceManager();
        service = manager.getJoinValidator();
        member=new Member();
        member.setUserId("userId");
        member.setUserPw("_aA123456");
    }

    @Test
    @DisplayName("회원가입 성공하면 예외 없음")
    public void joinSuccessTest(){
        assertDoesNotThrow(()->{
            service.join(member);
        });
    }
    @Test
    @DisplayName("Id null, 빈공간이면 예외발생")
    public void nullTest(){
        assertThrows(FailException.class,()->{
            member.setUserId(null);
            service.join(member);
        });
    }
    @Test
    @DisplayName("Pw null, 빈공간이면 예외발생")
    public void nullTest2(){
        assertThrows(FailException.class,()->{
            member.setUserPw(null);
            service.join(member);
        });
    }
    @Test
    @DisplayName("Id 길이 6~12자에 벗어나면 예외 발생")
    public void lengthTest(){
        assertThrows(FailException.class,()->{
            member.setUserId("aaaa");
            service.join(member);
        });
    }
    @Test
    @DisplayName("Pw 길이 8~16자에 벗어나면 예외 발생")
    public void lengthTest2(){
        assertThrows(FailException.class,()->{
            member.setUserPw("aaaa");
            service.join(member);
        });
    }


}
