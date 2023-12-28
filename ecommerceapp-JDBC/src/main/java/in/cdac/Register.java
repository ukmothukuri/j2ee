package in.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.cdac.dao.User;
import in.cdac.dbops.DBOperations;

public class Register extends HttpServlet {

       public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();     
        String username = req.getParameter("username");
        String useremail = req.getParameter("useremail");
        String usermobile = req.getParameter("usermobile");
        String userpassword = req.getParameter("userpwd");
        int userinterests = Integer.parseInt(req.getParameter("userinterests"));

        if(username != null 
        && useremail != null 
        && usermobile != null 
        && userpassword != null
        && userinterests != -1)
        {
            DBOperations dob = new DBOperations();

            User user = new User();
            user.setUseremail(useremail);
            user.setUsername(username);
            user.setUsermobile(usermobile);
            user.setUserpassword(userpassword);
            user.setUserinterests(userinterests);

            boolean status = dob.insertUserDetails(user);
            if(status){
                out.println("User Registration is successful.");
                out.println("<a href='/Login'>Click here</a> to login");
            } else{
                req.setAttribute("errormsg", "Registration failed. Please try after sometime");
                req.getRequestDispatcher("/jsp/Register.jsp").forward(req, resp);
            }

        }
    }
}
