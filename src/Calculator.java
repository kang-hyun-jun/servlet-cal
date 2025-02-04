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
import java.util.Stack;

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
            exp = calculator(exp);
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
    public String calculator(String exp)
    {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> calStack = new Stack<>();
        String num_temp="";
        for(int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            if(classification(c))
            {
                //분류상으로 연산자인 경우
                numStack.push(Integer.parseInt(num_temp));
                num_temp="";
                if(!calStack.isEmpty()&&weight(c)<=calStack.peek())
                {
                    int a = numStack.pop();
                    int b = numStack.pop();
                    char op = calStack.pop();
                    numStack.push(applyOperation(a, b, op));
                }
                else
                {
                    calStack.push(c);
                }
            }
            else
            {
                //숫자인경우
                num_temp+=String.valueOf(exp.charAt(i));
            }
        }
        numStack.push(Integer.parseInt(num_temp));

        while (!calStack.isEmpty()) {
            int b = numStack.pop();
            int a = numStack.pop();
            char op = calStack.pop();
            numStack.push(applyOperation(a, b, op));
        }
        exp = numStack.pop().toString();
        System.out.println(exp);
        return exp;
    }
    public int weight(char cal)
    {
        if((cal=='+')||(cal=='-'))
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public boolean classification(char cal)
    {
        if((cal=='+')||(cal=='-')||(cal=='*')||(cal=='/'))
        {
            return true;
            //연산자
        }
        else
        {
            return false;
            //숫자
        }
    }
    public int applyOperation(int a, int b, char op)
    {
        if(op=='+')
        {
            return a+b;
        }
        else if(op=='-')
        {
            return a-b;
        }
        else if(op=='*')
        {
            return a*b;
        }
        else {
            return a/b;
        }

    }
}