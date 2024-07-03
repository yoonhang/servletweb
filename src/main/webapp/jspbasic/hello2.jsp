<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			//자바코드를 쓸 수 있는 영역
			//-jsp문서에서 작성하는 모든 태그나 자바코드는 서블릿으로 변환되면서 _jspService메소드 내부 코드로 작성된다.
			//_jspService메소드 내부에서 작업하는 것과 동일하게 인식
			out.print("<img alt='' src='/serverweb/images/bts2.jpg' width='300'/>");
			out.print("<h2>가입을 환영합니다.</h2>");
		%>
	</body>
</html>