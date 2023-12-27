package in.cdac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class Servlet2 extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

       Cookie[] ck =  request.getCookies();
       for(Cookie c : ck){         
         if(c.getName().equals("userEmail")){
            System.out.println(c.getName()+""+c.getValue());
            System.out.println("You are a logged in user "+c.getValue());
         }
       }

    }

}
