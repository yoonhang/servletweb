package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;
import member.MemberDAOImpl;
import member.MemberDTO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "mvclist", urlPatterns = { "/member/mvc/list" })
public class MemberListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		
		//1. 요청정보추출
		//2. 비지니스메소드호출
		MemberDAO dao = new MemberDAOImpl();
		
		List<MemberDTO> userlist =  dao.select();
		//out.println(userlist);
		//3. 응답화면생성
		out.print("<h1>회원목록보기</h1>");
		out.print("<hr/>");
		out.print("<table border='1' width='600'>");
		out.print("<tr bgcolor='pink'>");
		out.print("<th>아이디</th><th>패스워드</th><th>성명</th>");
		out.print("<th>주소</th><th>가입날짜</th><th>포인트</th>");
		out.print("<th>정보</th><th>삭제</th>");
		out.print("</tr>");
		for(MemberDTO user:userlist) {
			out.print("<tr>");
			out.print("<td>"+user.getId()+"</td>");
			out.print("<td>"+user.getPass()+"</td>");
			out.print("<td>"+user.getName()+"</td>");
			out.print("<td>"+user.getAddr()+"</td>");
			out.print("<td>"+user.getRegDate()+"</td>");
			out.print("<td>"+user.getPoint()+"</td>");
			out.print("<td>"+user.getInfo()+"</td>");
			out.print("<td><a href='/serverweb/member/delete?id="+user.getId()+"'>삭제</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

}













