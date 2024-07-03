package dept;

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
@WebServlet(name = "deptinsert", urlPatterns = { "/dept/insert" })
public class DeptInsertServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		
		//1. 요청정보추출
		String deptno = request.getParameter("deptno");
		String deptname = request.getParameter("deptname");
		String pass = request.getParameter("tel");
		String tel = request.getParameter("addr");
		
		//2. 비지니스메소드 호출
		DeptDTO dept = new DeptDTO(deptno, deptname, tel, tel);
		DeptDAO dao = new DeptDAOImpl();
		
		int result = dao.insert(dept);
		System.out.println(result);
		//3. 응답메시지 생성
		if(result>=1) {
			out.print("<h3>"+result+"명의 부서등록 성공!!</h3>");
		}else {
			out.print("<h3>부서등록실패</h3>");
		}
	}

}











