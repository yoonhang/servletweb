<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp내장객체테스트(request,response객체)</title>
	</head>
	<body>
		<%
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			MemberDAOImpl dao = new MemberDAOImpl();
			MemberDTO user =  dao.login(id, pass);
		%>
		<h2>아이디:<%= id%></h2>
		<h2>패스워드:<%= pass%></h2>
		<%if(user!=null){ %>
			<h2><%=user.getName() %>님 로그인 성공!!</h2>
		<%}else{
			 response.sendRedirect("/serverweb/jspbasic/login.jsp");
		  }%>
	</body>
</html>