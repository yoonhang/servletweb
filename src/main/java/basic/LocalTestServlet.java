package basic;


// 파일명 : LocalTestServlet.java
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{
   protected void doGet(HttpServletRequest req,HttpServletResponse res)
           throws ServletException,IOException{
      String str = null;
      int number = 0;
      str = req.getParameter("sendmessage");
      res.setContentType("text/html; charset=UTF-8");
      PrintWriter out = res.getWriter();
      out.println("<html><head><title>MultiThread Test</title></head>");
      out.println("<body><h2>처리 결과(지역 변수)</h2>");
      while (number++ < 10) {
         String strnum = "[" + number + "]";
         out.println("MultiThreadTest : " + str +"  "+ strnum + "<br>");
         out.flush();
         System.out.println("MultiThreadTest : " + str +"  "+ strnum + "<br>");
         try {
            Thread.sleep(1000);
         } catch (Exception e) {
            System.out.println(e);
         }
      }                
      out.println("<h2>Done " + str + " !!</h2>");
      out.println("</body></html>");
      out.close();
   }
}
