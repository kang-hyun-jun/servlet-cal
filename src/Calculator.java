import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();

        String value = request.getParameter("value");
        String cal = request.getParameter("cal");
        String dot = request.getParameter("dot");

        String exp = "";

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equals("exp")) {
                    exp = c.getValue();
                    break;
                }
            }
        }

        if (cal != null && cal.equals("="))
        {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            try {
                exp = String.valueOf(engine.eval(exp));
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
        }
        else if (cal != null && cal.equals("C"))
        {
            exp ="";
        }
        else
        {
            exp += (value==null) ? "" : value;
            exp += (cal==null) ? "" : cal;
            exp += (dot==null) ? "" : dot;
        }



        Cookie expCookie = new Cookie("exp", exp);
        if (cal != null && cal.equals("C"))
        {
            expCookie.setMaxAge(0);
        }
        response.addCookie(expCookie);

        response.sendRedirect("myServlet");
    }
}