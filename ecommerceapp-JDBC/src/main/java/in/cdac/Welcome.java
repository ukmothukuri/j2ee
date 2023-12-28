package in.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            PrintWriter write = resp.getWriter();
            resp.setContentType("text/html");
            String userEmail = req.getParameter("useremail");

            String userRole = (String)req.getAttribute("role");

            write.println("Hi..."+userEmail);
            write.println("<br>");  
            write.println("You are logged in as a "+userRole);
            write.println("<br>");    
            write.println("<hr>");
            write.println("<br>");
            write.println("<h2>Products Catalog</h2>");
                                 
            write.println("<table border=>");
            write.println("<th>");
            write.println("<td>SNO</td>");
            write.println("<td>Product Name</td>");
            write.println("<td>Product Price</td>");
            write.println("</th>");

            write.println("<tr>");
            write.println("<td>1</td>");
            write.println("<td>Samsung Mobile S12</td>");
            write.println("<td>Rs. 15000</td>");
            write.println("</th>");

            write.println("<tr>");
            write.println("<td>2</td>");
            write.println("<td>Google Pixel 8</td>");
            write.println("<td>Rs. 55000</td>");
            write.println("</th>");
            write.println("</table>");

    }
}
