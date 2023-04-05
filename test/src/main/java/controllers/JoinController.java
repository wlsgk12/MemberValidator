package controllers;

import common.MessageUtil;
import models.member.JoinService;
import models.member.Member;
import models.member.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static common.MessageUtil.error;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/member/join.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ServiceManager manager=new ServiceManager();
            JoinService service = manager.getJoinValidator();
            Member member=new Member();
            member.setUserId(req.getParameter("userId"));
            member.setUserPw(req.getParameter("userPw"));
            service.join(member);

            String url = req.getContextPath() + "/member/login";
            MessageUtil.go(url,"parent",resp);
        }catch(RuntimeException e){
            e.printStackTrace();
            error(e,resp);
        }
    }
}
