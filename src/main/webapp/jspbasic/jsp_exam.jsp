<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table {
				width: 600px;
				height: 500px;
			}
		</style>
	</head>
	<body>
		<table border="1">
			<%for(int dan=1;dan<=9;dan++){ %>
				<tr>
					<%for(int i=1;i<=9;i++){ 
						if(dan==i){ %>
							<td><img alt="" src="/serverweb/images/bts2.jpg" width="50"/></td>
						<%}else{ %>
							<td><%= dan+"*"+i+"="+(dan*i) %></td>
						<%}
					} %>
				</tr>
			<%} %>
		</table>
	</body>
</html>