package in.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.cdac.dao.Product;
import in.cdac.dao.User;
import in.cdac.dbops.DBOperations;

@WebServlet("/login")
public class Login extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
                
        String useremail = req.getParameter("useremail");
        String userpassword = req.getParameter("userpwd");


        if(useremail != null 
        && userpassword != null){
            DBOperations dbOperations = new DBOperations();
            User user = new User();
            user.setUseremail(useremail);
            user.setUserpassword(userpassword);

            boolean status = dbOperations.validateUserDetails(user);
            if(status){
                HttpSession session = req.getSession(true);
                session.setAttribute("email", useremail);

                ArrayList<Product> prods =  dbOperations.getAllProductDetails();
                req.setAttribute("products", prods);
                req.getRequestDispatcher("/jsp/Welcome.jsp").forward(req, resp);    
            }else{
                req.setAttribute("errormsg", "Invalid User details");
                req.getRequestDispatcher("/jsp/Login.jsp").forward(req, resp);
            }
        }



        // if(useremail.equals("rajesh@cdac.in")
        // && userpassword.equals("cdac@123"))
        // {
        //     HttpSession session = req.getSession(true);
        //     session.setAttribute("email", useremail);
        //     req.getRequestDispatcher("/jsp/Welcome.jsp").forward(req, resp);
        // }
        // else{
        //    req.setAttribute("errormsg", "Invalid User details");
        //    req.getRequestDispatcher("/jsp/Login.jsp").forward(req, resp);
        // }
    }
}
