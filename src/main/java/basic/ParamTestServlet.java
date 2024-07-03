package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamTestServlet
 */
@WebServlet(name = "paramtest", urlPatterns = { "/paramtest" })
public class ParamTestServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		//요청정보에 한글 설정하기(한글인코딩적용)
		//요청정보를 추출하기 전에 한글인코딩을 등록
		request.setCharacterEncoding("UTF-8");
		//응답정보를 생성해서 response하기
		//1. 응답데이터의 형식과 인코딩을 설정
		//  => 응답정보에 한글을 설정 - 출력될 응답의 형식을 지정(MIME타입 - text/html)
		response.setContentType("text/html;charset=UTF-8");
		//2. 클라이언트에 응답할 스트림객체를 생성(네트워크통신에서 소켓으로 부터 통신할 스트림을 얻는 과정과 동일한 과정)
		PrintWriter out =  response.getWriter();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println("아이디:"+id);
		System.out.println("패스워드:"+pass);
		
		out.print("<h1>응답데이터</h1>");
		out.println("<hr/>");
		out.print("<h3>아이디:"+id+"</h3>");
		out.print("<h3>패스워드:"+pass+"</h3>");
	}

}













