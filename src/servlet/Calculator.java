package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String f_num = request.getParameter("f-num");
        String s_num = request.getParameter("s-num");
        String cal = request.getParameter("cal");
        out.println("<a href=\"Calculator.html\">다시 계산하기!</a><br>");
        if (f_num != null && !f_num.equals("")&&s_num != null && !s_num.equals(""))
        {
            if (cal.equals("plus"))
            {
                int a = Integer.parseInt(f_num);
                int b = Integer.parseInt(s_num);
                int sum = a+b;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            }
            else if (cal.equals("multiply"))
            {
                int a = Integer.parseInt(f_num);
                int b = Integer.parseInt(s_num);
                int sum = a*b;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            }
            else if (cal.equals("minus"))
            {
                int a = Integer.parseInt(f_num);
                int b = Integer.parseInt(s_num);
                int sum = a-b;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            }
            else if (cal.equals("divide"))
            {
                int a = Integer.parseInt(f_num);
                int b = Integer.parseInt(s_num);
                int sum = a/b;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            }

        }
        else
        {
            out.println("<h1>올바른 숫자를 입력하세요!</h1>");
        }


    }
}
