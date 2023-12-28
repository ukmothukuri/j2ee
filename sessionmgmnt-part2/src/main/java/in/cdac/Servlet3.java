package in.cdac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Servlet3 extends HttpServlet{
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        String email = request.getParameter("useremail");
        String password = request.getParameter("userpwd");

        // server side validation
        if(email == "" || email.isEmpty()){
            request.setAttribute("emailmsg","Email cannot be empty");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        if(password == "" || password.isEmpty()){
            request.setAttribute("pwdmsg","Password cannot be empty");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else{
                if(email.equals("rajesh@cdac.in")
            && password.equals("cdac@123")){
                HttpSession session = request.getSession(true);
                System.out.println("----- "+session.getId());
                session.setAttribute("email", email);
            }
        }        
    }    
}
