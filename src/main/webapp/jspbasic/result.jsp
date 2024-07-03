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
		<h2>요청재지정으로 실행되는 jsp -서블릿이 공유해준 데이터를 꺼내서 웹페이지 출력하기</h2>
		<%
		   //공유데이터꺼내기
		   MemberDTO data = (MemberDTO)request.getAttribute("mydata");
		%>
		<h2><%= data.getId() %>님 환영합니다.!!!</h2>
	</body>
</html>