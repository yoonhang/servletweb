<%@page import="member.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>scriptTest</title>
	</head>
	<body>
		<h1>jsp문법 - 스크립트 요소</h1>
		<h3>1. 주석문</h3>
		<!-- html주석문(클라이언트에 전송 )-->
		<%-- jsp주석(jsp요소에 주석을 처리하는 용도 - 클라이언트에 전송되지 않는다.) --%>
		<%
			//자바주석
			/*
			   자바주석(클라이언트에 전송되지 않는다.)
			*/
		%>
		<h3>2. 스크립트릿</h3>
		<%
			/*
			  스크립트릿은 자바코드를 쓸 수 있는 영역
			  반드시 명령문인 경우에는 문장의 끝에 ;을 추가
			  자바나 서블릿에서 쓸 수 있는 모든 코드를 사용할 수 있다.
			  단, jsp는 만들어진 목적이 서블릿에 뷰를 분리하기 위해서 만들어졌으므로 JSP에서는 자바코드를 지양
			  jsp에서는 서블릿에서 공유한 데이터를 꺼내서 출력하는 일만 담당
			  => EL JSTL(자바코드를 쓰지 않기 위해 만들어진 기술)
			*/
			String str = new String("java");
		%>
		<h3>스크립트릿은 자바코드를 쓸 수 있고 jsp문서내에서 여러 번 사용이 가능</h3>
		<hr/>
		<%if(str.length()>=4){ %>
			<h2>정상수행 - html을 if블럭 안에 추가할 수 있다.</h2>
		<%}else{ %>
			<h2>if조건이 만족하지 않는 경우</h2>
		<%} %>
		
		<h3>3. 표현식(변수, 메소드호출결과(리턴값이 있는 메소드를 호출),문자열, 연산식등을 출력하기 위해 사용)</h3>
		<h4>서블릿으로 변환될때 표현식으로 정의한 것들은 out.print메소드의 매개변수로 전달되므로 ;을 추가하지 않는다.</h4>
		<h4>표현식으로 작성하는 값:<%= str %></h4>
		<h4>표현식으로 작성하는 값:<%= str.length() %></h4>
		<h4>표현식으로 작성하는 값:<%= "str" %></h4>
		<h4>표현식으로 작성하는 값:<%= 10 %></h4>
		<h4>표현식으로 작성하는 값:<%= 10.5 %></h4>
		<h4>표현식으로 작성하는 값:<%= 'A' %></h4>
		<h4>표현식으로 작성하는 값:<%= true %></h4>
		<h4>표현식으로 작성하는 값:<%= 10/3 %></h4>
		<h4>표현식으로 작성하는 값:<%= new Date().toString() %></h4>
		<% MemberDTO user = new MemberDTO(); %>
		
		<h3>4. 선언문 - 멤버변수나 메소드 정의</h3>
		<%
			int num = 100;//_jspService메소드의 지역변수로 정의
		%>
		<%! int num = 100000; //변환된 서블릿클래스의 멤버변수로 정의 %>
		<%! public void test(){
				System.out.println("test");
			}
		%>
	</body>
</html>













