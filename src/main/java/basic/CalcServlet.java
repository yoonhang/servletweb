package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		//한글셋팅과 출력스트림구하기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		//1. 클라이언트의 요청정보를 추출
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String opr = request.getParameter("method");
		
		//2. 비지니스 로직을 구현
		//2. 비지니스 메소드를 호출
		Calc logic = new Calc();
		int result = logic.calc(num1, num2, opr);
		
		//3. 클라이언트에 응답할 메시지를 생성
		out.println("<h1>계산결과</h1>");
		out.println("<hr/>");
		out.println("<h3>num1의 "+num1+"과 num2의 "+num2+"를 연산한 결과"+result+"입니다.</h3>");
	}

}









