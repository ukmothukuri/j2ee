package in.cdac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome")
public class Servlet4 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
         HttpSession session = request.getSession(false);
         if(session != null){
            System.out.println("Welcome .."+session.getAttribute("email"));
         }else{
            System.out.println("Your session is already expired");
         }

    }
}
