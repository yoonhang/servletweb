<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<% //공유된 데이터 꺼내기
		   MemberDTO user = (MemberDTO)	request.getAttribute("loginUser");
		   if(user!=null){%>
		   		<h2><%= user.getName() %>(<%=user.getId() %>)님 로그인 성공!!</h2>
		   <%}else{ 
		    	response.sendRedirect("/serverweb/member_mvc/login.jsp");
		   	 }
		   %> 
	</body>
</html>