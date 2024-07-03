package basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDTO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "redirect", urlPatterns = { "/redirect" })
public class SendRedirectTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		
		System.out.println("sendRedirect연습 - SendRedirectTestServlet");
		out.print("<h1>요청재지정연습 - sendRedirect</h1>");
		
		//데이터공유하기
		MemberDTO dto = new MemberDTO("bts1", "1234", "슈가", "대구", "래퍼");
		//공유하고 싶은 scope객체의 메소드를 호출
		request.setAttribute("mydata", dto);
		
		//요청재지정
		response.sendRedirect("/serverweb/jspbasic/result.jsp");
	}
}
