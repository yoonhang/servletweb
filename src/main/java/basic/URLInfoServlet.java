package basic;


// 파일명 : URLInfoServlet.java
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/URLInfoServlet")
public class URLInfoServlet extends HttpServlet {
	public void doGet (HttpServletRequest req, HttpServletResponse res)	
                     		throws ServletException, IOException {
    PrintWriter out;
    res.setContentType("text/html; charset=UTF-8");
		out = res.getWriter ();
		out.println("<html>");
		out.println("<head><title>Request 정보 출력 Servlet</title></head>");
		out.println("<body>");
		out.println("<h3>요청 방식과 프로토콜 정보</h3>");
		out.println("<pre>");
		out.println("Request URI : "+ req.getRequestURI());
		out.println("Request URL : "+ req.getRequestURL());
		out.println("Context Path : "+ req.getContextPath());
		out.println("Request Protocol : "+ req.getProtocol());
		out.println("Servlet Path : "+ req.getServletPath());
		out.println("</pre>");
		out.println("</body></html>");
   }  	
}
