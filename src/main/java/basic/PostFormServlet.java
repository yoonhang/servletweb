package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostFormServlet
 */
@WebServlet(name = "post", urlPatterns = { "/post.do" })
public class PostFormServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글셋팅과 출력스트림구하기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		//클라이언트가 입력한 요청정보를 추출
		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] items = request.getParameterValues("item");
		
		//응답메시지를 생성
		out.print("<h1>customer</h1>");
		out.print("<hr/>");
		out.print("<h3>아이디:"+id+"</h3>");
		out.print("<h3>성명:"+name+"</h3>");
		out.print("<h3>패스워드:"+passwd+"</h3>");
		out.print("<h3>성별:"+gender+"</h3>");
		out.print("<h3>직업:"+job+"</h3>");
		out.print("<h3>좋아하는 항목:");
		for(String item:items) {
			out.print(item +" ");
		}
		out.print("</h3>");
	}

}
