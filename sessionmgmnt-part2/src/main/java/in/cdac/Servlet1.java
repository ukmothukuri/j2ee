package in.cdac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
public class Servlet1 extends HttpServlet{
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

        String email = request.getParameter("useremail");
        String password = request.getParameter("userpwd");

        if(email.equals("rajesh@cdac.in") && password.equals("cdac@123")){
            Cookie ck = new Cookie("userEmail", email);
            ck.setMaxAge(150000);
            response.addCookie(ck);
        }    


    }

}
