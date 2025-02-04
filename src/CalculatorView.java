import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myServlet")
public class CalculatorView extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String exp ="0";
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("exp")) {
                    exp = cookie.getValue();
                    break;
                }
            }
        }
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>My calculater</title>");
        out.println("<link rel=\"icon\" type=\"image/png\" href=\"./img/calculator.png\" />");
        out.println("<script src=\"https://cdn.tailwindcss.com\"></script>");
        out.println("</head>");
        out.println("<body class=\"bg-gray-100\">");
        out.println("<div id=\"app\" class=\"min-h-screen\">");
        out.println("<!-- Navigation -->");
        out.println("<nav class=\"bg-purple-700 text-white p-4\">");
        out.println("</nav>");
        out.println("<!-- Login Form -->");
        out.println("<div  class=\"container mx-auto p-8\">");
        out.println("<div class=\"max-w-md mx-auto bg-amber-50 p-8 rounded-lg shadow-lg\">");
        out.println("<h2 class=\"text-2xl font-bold text-purple-700 mb-6\">calculator</h2>");
        out.println("<form action=\"http://localhost:8080/Calculator\" method=\"post\">");
        out.println("<table class=\"w-full\">");
        out.println("<tr>");
        out.printf("<td colspan=\"4\"><h2 class=\"text-2xl font-bold text-purple-700 mb-6 pr-5 text-right\">%s</h2></td>\n",exp);
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"w-1/4\"><input type=\"submit\" name =\"cal\" value=\"CE\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td class=\"w-1/4\"><input type=\"submit\" name =\"cal\" value=\"C\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td class=\"w-1/4\"><input type=\"submit\" name =\"cal\" value=\"BS\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td class=\"w-1/4\"><input type=\"submit\" name =\"cal\" value=\"÷\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"7\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"8\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"9\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"cal\" value=\"×\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"4\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"5\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"6\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"cal\" value=\"-\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"1\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"2\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"3\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"cal\" value=\"+\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" name =\"cal\" value=\"±\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"value\" value=\"0\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"cal\" value=\".\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("<td><input type=\"submit\" name =\"cal\" value=\"=\" class=\"w-full bg-purple-700 text-white py-3 rounded hover:bg-purple-800 transition\"></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
