package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@MockitoSettings(strictness = Strictness.WARN)
@ExtendWith(MockitoExtension.class)
public class LoginTest {
    private Member member;
    @Mock
    private HttpServletRequest request;
    private ServiceManager manager;
    private LoginService service;
    private MemberDao memberDao;
    @BeforeEach
    public void init(){
        member=new Member();
        member.setUserId("userId");
        member.setUserPw("12345678");
        manager= new ServiceManager();
        service = manager.getLoginValidator();
        memberDao = new MemberDao();
        memberDao.add(member);

    }
    private void realMember(){ //실제 아이디 비번 담은 메서드
        given(request.getParameter("userId")).willReturn(member.getUserId());
        given(request.getParameter("userPw")).willReturn(member.getUserPw());
    }
    private void createMember(String userId, String userPw) {//아이디 비번 따로 입력하는 임시 데이터 메서드
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }
    @Test
    @DisplayName("로그인 성공시 예외 발생x")
    public void loginSuccessTest(){
        realMember();
        assertDoesNotThrow(()->{
           service.login(request);
        });
    }//LoginService에서 session 주석처리하면 오류 안뜸
    @Test
    @DisplayName("id, pw 빈공간 시 예외 발생")
    public void idPwNullTest(){
        createMember("null",null);
        assertThrows(FailException.class,()->{
            service.login(request);
        });
    }
    @Test
    @DisplayName("저장한 회원정보와 일치하지않으면 예외 발생")
    public void memberRealTest(){
        createMember("aa",member.getUserPw());
        assertThrows(FailException.class,()->{
            service.login(request);
        });
    }
}
