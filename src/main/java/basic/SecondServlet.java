package basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException{
		for(int i=1;i<=9;i++) {
			System.out.println("7*"+i +"="+(7*i));
		}
	}

}
