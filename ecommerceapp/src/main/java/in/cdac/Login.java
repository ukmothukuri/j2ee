package in.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String useremail = req.getParameter("useremail");
        String userpassword = req.getParameter("userpwd");

        if(useremail.equals("rajesh@cdac.in")
        && userpassword.equals("cdac@123"))
        {
            //out.println("Congratulations..<br>You have succesfully logged in"); 
            
            req.setAttribute("role", "customer");
            req.getRequestDispatcher("/welcome").forward(req, resp);
            

            //resp.sendRedirect("./welcome");

        }
        else{
            out.println("Invalid user details");
            out.println("Please <a href='./html/Login.html'>click here</a> to login again");            
        }
    }
}
