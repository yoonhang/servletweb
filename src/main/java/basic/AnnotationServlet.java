package basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebServlet은 서블릿을 등록하기 위한 어노테이션
//@WebServlet의 속성을 정의할 수 있다.
//@WebServlet의 name속성은 서블릿의 이름을 등록하기 위한 속성
//@WebServlet의 urlPatterns은 서블릿을 요청하기 위한 path를 등록, 여러 개를 등록할 수 있어서 {}로 관리
//어노테이션을 이용해서 서블릿을 등록하는 것도 xml에 내용을 변경하는 것과 동일하게 서버를 restart
//서블릿명이 중복되면 실행되지 않는다
@WebServlet(name = "anno_servlet",urlPatterns = {"/test/anno.html"} )
public class AnnotationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {
		System.out.println("어노테이션으로 서블릿등록하기");
	}
	
}
