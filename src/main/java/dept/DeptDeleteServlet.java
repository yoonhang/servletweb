package dept;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "deptdel", urlPatterns = { "/dept/delete" })
public class DeptDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		
		//1. 요청정보추출
		String deptno = request.getParameter("deptcode");
		
		//2. 비지니스메소드 호출
		DeptDAO dao = new DeptDAOImpl();
		int result = dao.delete(deptno);
		
		//3. 응답메시지 생성
//		if(result>=1) {
//			out.print("<h3>"+result+"명의 회원 탈퇴 성공!!</h3>");
//		}else {
//			out.print("<h3>회원탈퇴실패</h3>");
//		}
		
		//삭제 후 MemberListServlet이 다시 실행되도록 요청하기
		response.sendRedirect("/serverweb/dept/list");
	}

}












