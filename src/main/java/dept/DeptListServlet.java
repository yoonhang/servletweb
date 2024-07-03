package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "deptlist", urlPatterns = { "/dept/list" })
public class DeptListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		
		//1. 요청정보추출
		//2. 비지니스메소드호출
		DeptDAO dao = new DeptDAOImpl();
		
		List<DeptDTO> deptlist =  dao.select();
		//out.println(userlist);
		//3. 응답화면생성
		out.print("<h1>부서목록보기</h1>");
		out.print("<hr/>");
		out.print("<table border='1' width='600'>");
		out.print("<tr bgcolor='pink'>");
		out.print("<th>부서번호</th><th>부서명</th><th>전화번호</th>");
		out.print("<th>주소</th><th>삭제</th>");
		out.print("</tr>");
		for(DeptDTO dept:deptlist) {
			out.print("<tr>");
			out.print("<td>"+dept.getDeptno()+"</td>");
			out.print("<td>"+dept.getDeptname()+"</td>");
			out.print("<td>"+dept.getTel()+"</td>");
			out.print("<td>"+dept.getAddr()+"</td>");
			out.print("<td><a href='/serverweb/dept/delete?deptcode="+dept.getDeptno()+"'>삭제</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

}













