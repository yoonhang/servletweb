package basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)
									throws ServletException,IOException{
		System.out.println("First서블릿....");
	}
}
