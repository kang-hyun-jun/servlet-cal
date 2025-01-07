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
        ServletContext application = request.getServletContext(); // application객체 (servlet context)

        //사용자 입력으로부터 value값과 cal값 획득
        String value = request.getParameter("value");
        String cal = request.getParameter("cal");

        //value에 초기값 부여 및 정수화
        int value_int = 0;
        if (value != null && !value.equals("")) {
            value_int = Integer.parseInt(value);
        }else
        {
            out.println("<h1>올바른 숫자를 입력하세요!</h1>");
        }

        //값을 계산
        if (cal.equals("=")) {
            int x = (Integer) application.getAttribute("value");
            int y = value_int;
            String cal_str = (String) application.getAttribute("cal");
            if (cal_str.equals("+")) {
                int sum = x + y;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            } else if (cal_str.equals("*")) {
                int sum = x * y;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            } else if (cal_str.equals("-"))
            {
                int sum = x - y;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            } else if (cal_str.equals("/"))
            {
                int sum = x / y;
                out.println("<h1>계산 결과 : "+sum+"</h1>");
            }
        }
        //값을 저장
        else
        {
            application.setAttribute("value", value_int);//요소 저장
            application.setAttribute("cal", cal);//요소 저장
        }



        out.println("<a href=\"Calculator.html\">다시 계산하기!</a><br>");



    }
}
