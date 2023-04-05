package common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtil {

    public static void error(Exception e, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.printf("<script>alert('%s');</script>",e.getMessage());
    }
    public static void go(String url, String target, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out= response.getWriter();
        out.printf("<script>%s.location.replace('%s');</script>",target,url);
    }
    public static void go(String url, HttpServletResponse response) throws IOException{
        go(url, "self", response);
    }
}
