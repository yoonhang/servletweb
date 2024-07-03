package member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet(name = "insert", urlPatterns = { "/member/insert" })
public class MemberInsertServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		
		//1. 요청정보추출
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String addr = request.getParameter("addr");
		String info = request.getParameter("info");
		
		//2. 비지니스메소드 호출
		MemberDTO member = new MemberDTO(id, pass, name, addr, info);
		MemberDAO dao = new MemberDAOImpl();
		
		int result = dao.insert(member);
		System.out.println(result);
		//3. 응답메시지 생성
		if(result>=1) {
			out.print("<h3>"+result+"명의 회원 가입이 성공!!</h3>");
		}else {
			out.print("<h3>회원등록실패</h3>");
		}
	}

}











