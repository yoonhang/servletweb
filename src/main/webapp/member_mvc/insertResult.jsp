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
			//공유된 데이터 꺼내기
			int result = (int) request.getAttribute("insert_result");
			if(result>=1){%>
				<h2><%= result %>개 행 삽입성공!!</h2>	
			<%}else{ %>
				<h2>삽입실패</h2>
			<%} %>
	</body>
</html>