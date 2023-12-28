package in.cdac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Servlet5 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
         HttpSession session = request.getSession(false);
         if(session != null){
            System.out.println("You .."+session.getAttribute("email")+" pressed the logout");
            session.invalidate();
         }
    }
}
