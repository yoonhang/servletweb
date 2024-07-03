package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;
import member.MemberDAOImpl;
import member.MemberDTO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet(name = "mvcinsert", urlPatterns = { "/member/mvc/insert" })
public class MemberInsertServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		System.out.println("-------------------------------------------------------------");
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
		//3. 데이터공유하기
		request.setAttribute("insert_result", result);
		
		//4. 요청재지정 - insertResult.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/insertResult.jsp");
		rd.forward(request, response);
	}

}











