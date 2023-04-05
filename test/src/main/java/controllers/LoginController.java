package controllers;

import models.member.LoginService;
import models.member.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static common.MessageUtil.*;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServiceManager manager = new ServiceManager();
            LoginService service = manager.getLoginValidator();
            service.login(req);

            String saveId = req.getParameter("saveId");
            String userId = req.getParameter("userId");
            Cookie cookie = new Cookie("saveId", userId);
            if(saveId != null){
                cookie.setMaxAge(60 * 60 * 24 * 365);
            }else {
                cookie.setMaxAge(0);
            }
            resp.addCookie(cookie);

            String url = req.getContextPath();
            go(url, "parent", resp);
        }catch (RuntimeException e){
            e.printStackTrace();
            error(e, resp);

        }
    }
}
